package com.pe.nttdata.services;

import com.pe.nttdata.entity.Empresarial;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Interface EmpresarialService. <br/>
 *<b>Class</b>: {@link EmpresarialService}<br/>
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
 *<li>Mar. 8, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
public interface EmpresarialService {

  public Flux<Empresarial> findAll();

  public Mono<Empresarial> findById(String id);

  public Mono<Empresarial> save(Empresarial empresa);

  public Mono<Void> deleteById(String id);

}
