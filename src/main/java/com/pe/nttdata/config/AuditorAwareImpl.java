package com.pe.nttdata.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

/**
 *Implement AuditorAwareImpl. <br/>
 *<b>Class</b>: {@link AuditorAwareImpl}<br/>
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
public class AuditorAwareImpl implements AuditorAware<String> {

  /**
   * .
   * String usuario
   **/
  @Value("${user.backend}")
  private String usuario;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link String}&lt;
   * @see String
   */
  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of(usuario);
  }

}