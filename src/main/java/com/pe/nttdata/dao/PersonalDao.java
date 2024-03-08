package com.pe.nttdata.dao;

import com.pe.nttdata.model.entity.Personal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Interface PersonalDao. <br/>
 *<b>Class</b>: {@link PersonalDao}<br/>
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
public interface PersonalDao {

  public Flux<Personal>  findAll();

  public Mono<Personal> findById(String id);

  public Mono<Personal> save(Personal personal);

  public Mono<Void> deleteById(String id);

}
