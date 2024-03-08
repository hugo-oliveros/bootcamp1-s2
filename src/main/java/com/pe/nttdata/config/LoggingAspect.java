package com.pe.nttdata.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.nttdata.commons.AspectEnum;
import com.pe.nttdata.dto.AppProcesoLogDto;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
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
  private final List<Object> listaParametros = new ArrayList<>();
  private String parametros;

  private AppProcesoLogDto logSystem = AppProcesoLogDto.builder().build();

  /**
   * <p/>
   * Capture parameter of controller endpoint.
   *
   * @param joinPoint {@link ProceedingJoinPoint}
   * @see ProceedingJoinPoint
   */
  @Around(value = "execution(* com.pe.nttdata.expose.web..*(..))")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint) {

    listaParametros.clear();
    logSystem = AppProcesoLogDto.builder().build();

    try {
      Arrays.asList(joinPoint.getArgs()).forEach(req -> {
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

    logSystem.setFechaInicioEjecucion(new java.util.Date());
    logSystem.setModulo(aplicatiobName);
    try {

      if (joinPoint.proceed() instanceof Mono) { //if Mono
        return Mono.from(((Mono<?>) joinPoint.proceed()).doOnNext(response -> {
          getProcees(joinPoint, response);
        }));

      } else { //if Flux
        return Flux.from(((Flux<?>) joinPoint.proceed()).doOnNext(response -> {
          getProcees(joinPoint, response);
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


  private void getProcees(ProceedingJoinPoint joinPoint, Object response) {
    final long start = System.currentTimeMillis();

    final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    final Method method = signature.getMethod();
    logSystem.setClaseProgramacion(signature.getDeclaringType().getSimpleName());
    logSystem.setMetodoProgramacion(method.getName());
    String claseHija = joinPoint.getTarget().getClass().getSimpleName();
    if (Optional.ofNullable(claseHija).isPresent()) {
      logSystem.setClaseProgramacion(claseHija);
    }
    logSystem.setDescripcionEstadoEjecucion(AspectEnum.MENSAJEOK.value());
    logSystem.setEstadoEjecucion(AspectEnum.EXITO.getValue());
    logSystem.setFechaFinEjecucion(new java.util.Date());

    final long executionTime = System.currentTimeMillis() - start;
    logSystem.setDuracionMs((int) executionTime);
    logSystem.setResultadoSalida(response.toString());
    log.info("\u001B[33mLog logExecutionTime - ** \u001B[36m{} \u001B[33m** \u001B[0m", logSystem.toString());

  }

}
