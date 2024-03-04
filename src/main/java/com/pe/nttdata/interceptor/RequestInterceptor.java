package com.pe.nttdata.interceptor;

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
    log.info("1 - pre handle.");
    log.info("METHOD type:{}", request.getMethod());
    log.info("Request URI: {}", request.getRequestURI());
    log.info("Servlet PATH: {}", request.getServletPath());
    if (object instanceof HandlerMethod) {
      Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
      String methodName = ((HandlerMethod) object).getMethod().getName();
      log.info("Controller name: {}", controllerClass.getName());
      log.info("Method name: {}", methodName);
    }
    log.info("--------------------------------------------");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView) throws Exception {
    log.info("Post Handle method is Calling");
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception exception) throws Exception {
    log.info("Request and Response is completed");
  }

}
