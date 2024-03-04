package com.pe.nttdata.services;

import com.pe.nttdata.entity.Personal;
import com.pe.nttdata.repository.PersonalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *Implement PersonalService. <br/>
 *<b>Class</b>: {@link PersonalService}<br/>
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
@Service
@Slf4j
public class PersonalService {

  @Autowired
  private PersonalRepository personalRepository;

  public Flux<Personal> findAll() {
    return personalRepository.findAll();
  }

  public Mono<Personal> findById(String id) {
    return personalRepository.findById(id);
  }

  public Mono<Personal> save(Personal persona) {
    return personalRepository.save(persona);
  }

  public Mono<Void> deleteById(String id) {
    return personalRepository.deleteById(id);
  }

}
