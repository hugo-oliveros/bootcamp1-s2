package com.pe.nttdata.dao.impl;

import com.pe.nttdata.dao.EmpresarialDao;
import com.pe.nttdata.dao.repository.EmpresarialRepository;
import com.pe.nttdata.model.entity.Empresarial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Class EmpresarialDaoImpl. <br/>
 *<b>Class</b>: {@link EmpresarialDaoImpl}<br/>
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
public class EmpresarialDaoImpl implements EmpresarialDao {

  @Autowired
  private EmpresarialRepository empresaRepository;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Empresarial}&gt;
   * @see String
   * @see Flux
   */
  @Override
  public Flux<Empresarial> findAll() {
    return empresaRepository.findAll();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link Empresarial}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<Empresarial> findById(String id) {
    return empresaRepository.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param empresa {@link String}
   * @return {@link Mono}&lt;{@link Empresarial}&gt;
   * @see String
   * @see Mono
   */
  @Override
  public Mono<Empresarial> save(Empresarial empresa) {
    return empresaRepository.save(empresa);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link Empresarial}&gt;
   * @see String
   * @see Mono
   * @see Void
   */
  @Override
  public Mono<Void> deleteById(String id) {
    return empresaRepository.deleteById(id);
  }

}
