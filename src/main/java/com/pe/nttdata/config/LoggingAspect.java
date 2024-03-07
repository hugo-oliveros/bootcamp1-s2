package com.pe.nttdata.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.nttdata.commons.AspectEnum;
import com.pe.nttdata.dto.AppProcesoLogDto;
import com.pe.nttdata.util.DateUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *Implement LoggingAspect. <br/>
 *<b>Class</b>: {@link LoggingAspect}<br/>
 *<b>Copyright</b>: &Copy; 2024 NTTDATA Per&uacute;. <br/>
 *<b>Company</b>: NTTDATA del Per&uacute;. <br/>
 *
 *@author NTTDATA Per&uacute;. (EVE) <br/>
 *<u>Developed by</u>: <br/>
 *<ul>
 *<li>Hugo Oliveros Monti</li>
 *</ul>
 *<u>Changes</u>:<br/>
 *<ul>
 *<li>Mar. 7, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

  @Value("${user.aplicationName}")
  private String aplicatiobName;

  private final int maxCharOutput = 3950;
  private List<Object> listaParametrosTmp = null;
  private List<Object> listaParametros = new ArrayList<>();
  private String parametros;

  private AppProcesoLogDto logSystem = AppProcesoLogDto.builder().build();

  /**
   * <p/>
   * Capture parameter of controller endpoint.
   *
   * @param joinPoint {@link ProceedingJoinPoint}
   * @see ProceedingJoinPoint
   */
  @Around(value = "execution(* com.pe.nttdata.controller..*(..))")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint) {


    try {
      listaParametrosTmp = Arrays.asList(joinPoint.getArgs());
      listaParametrosTmp.forEach(req -> {
        if (!(req instanceof HttpServletRequest
                || req instanceof BindingResult
                || req instanceof UriComponentsBuilder)) {
          listaParametros.add(req);
        }
      });

      if (listaParametros != null && !listaParametros.isEmpty()) {
        ObjectMapper mapperEntrada = new ObjectMapper();
        mapperEntrada.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        parametros = mapperEntrada
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(listaParametros);
        if (parametros.length() >= maxCharOutput) {
          parametros = parametros.substring(0, maxCharOutput);
        }

        logSystem.setParametroEntrada(parametros);
      }

    } catch (Exception e) {
      log.error("Log logExecutionTime - exception  {}", e.getMessage());
      log.error("Log logExecutionTime - exception  list parameter: {}", listaParametros);
      logSystem.setParametroEntrada(null);
    }

    final long start = System.currentTimeMillis();
    logSystem.setFechaInicioEjecucion(new java.util.Date());
    logSystem.setModulo(aplicatiobName);

    ///Object proceed = null;
    try {

      if (joinPoint.proceed() instanceof Mono) { //if Mono

        return Mono.from(((Mono<?>) joinPoint.proceed()).doOnNext(response -> {
          final long executionTime = System.currentTimeMillis() - start;
          logSystem.setDescripcionEstadoEjecucion(AspectEnum.MENSAJEOK.value());
          logSystem.setEstadoEjecucion(AspectEnum.EXITO.getValue());
          final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
          final Method method = signature.getMethod();
          logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());
          logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());
          String claseHija = joinPoint.getTarget().getClass().getSimpleName();
          if (Optional.ofNullable(claseHija).isPresent()) {
            logSystem.setClaseProgramacion(claseHija);
          }
          logSystem.setFechaFinEjecucion(new java.util.Date());
          logSystem.setDuracionMs((int) executionTime);
          logSystem.setResultadoSalida(response.toString());
          log.info("\u001B[33mLog logExecutionTime - ** {} ** \u001B[0m", logSystem.toString());
        }));

      } else { //if Flux

        return Flux.from(((Flux<?>) joinPoint.proceed()).doOnNext(response -> {
          final long executionTime = System.currentTimeMillis() - start;
          logSystem.setDescripcionEstadoEjecucion(AspectEnum.MENSAJEOK.value());
          logSystem.setEstadoEjecucion(AspectEnum.EXITO.getValue());
          final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
          final Method method = signature.getMethod();
          logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());
          logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());
          String claseHija = joinPoint.getTarget().getClass().getSimpleName();
          if (Optional.ofNullable(claseHija).isPresent()) {
            logSystem.setClaseProgramacion(claseHija);
          }
          logSystem.setFechaFinEjecucion(DateUtils.obtenerFechaHoraActual());
          logSystem.setDuracionMs((int) executionTime);
          log.info("\u001B[33mLog logExecutionTime - ** {} ** \u001B[0m", logSystem.toString());
        }));

      }

    } catch (Exception e) {
      log.error("Log logExecutionTime - exception {},", e.getMessage());
    } catch (Throwable e) {
      log.error("Log logExecutionTime - ** endProcess Error {} ** ", logSystem.toString());
      throw new RuntimeException(e);
    }

    return null;

  }



}
