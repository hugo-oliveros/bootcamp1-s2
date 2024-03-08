package com.pe.nttdata.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *Implement RequestInterceptor. <br/>
 *<b>Class</b>: {@link RequestInterceptor}<br/>
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
 *<li>feb. 29, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response, Object object) {
    log.info("\u001B[32m1 - pre handle.\u001B[0m");
    log.info("\u001B[32mMETHOD type:{}\u001B[0m", request.getMethod());
    log.info("\u001B[32mRequest URI: {}\u001B[0m", request.getRequestURI());
    log.info("\u001B[32mServlet PATH: {}\u001B[0m", request.getServletPath());
    if (object instanceof HandlerMethod) {
      Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
      String methodName = ((HandlerMethod) object).getMethod().getName();
      log.info("\u001B[34mController name: {}\u001B[0m", controllerClass.getName());
      log.info("\u001B[34mMethod name: {}\u001B[0m", methodName);
    }
    log.info("\u001B[34m--------------------------------------------\u001B[0m");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView) throws Exception {
    log.info("\u001B[32mPost Handle method is Calling\u001B[0m");
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception exception) throws Exception {
    log.info("\u001B[32mRequest and Response is completed\u001B[0m");
  }

}
