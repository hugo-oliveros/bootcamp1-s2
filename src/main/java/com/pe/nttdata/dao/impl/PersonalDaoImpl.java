package com.pe.nttdata.dao.impl;

import com.pe.nttdata.dao.PersonalDao;
import com.pe.nttdata.dao.repository.PersonalRepository;
import com.pe.nttdata.model.entity.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Class PersonalDaoImpl. <br/>
 *<b>Class</b>: {@link PersonalDaoImpl}<br/>
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
@Service
public class PersonalDaoImpl implements PersonalDao {

  @Autowired
  private PersonalRepository personalRepository;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Personal}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<Personal> findAll() {
    return personalRepository.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link Personal}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<Personal> findById(String id) {
    return personalRepository.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param personal {@link String}
   * @return {@link Mono}&lt;{@link Personal}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<Personal> save(Personal personal) {
    return personalRepository.save(personal);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link com.pe.nttdata.model.entity.Persona}&gt;
   * @see String
   * @see Mono
   * @see Void
   */
  @Override
  public Mono<Void> deleteById(String id) {
    return personalRepository.deleteById(id);
  }

}
