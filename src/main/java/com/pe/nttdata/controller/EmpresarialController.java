package com.pe.nttdata.controller;


import com.pe.nttdata.entity.Empresarial;
import com.pe.nttdata.repository.EmpresarialRepository;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *Implement EmpresaRepository. <br/>
 *<b>Class</b>: {@link EmpresarialController}<br/>
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

@RestController
@RequestMapping("empresarial/api/v1")
@CrossOrigin("*")
@Slf4j
public class EmpresarialController {

  /**
   * .
   * EmpresaRepository empresaRepository
   **/
  @Autowired
  private EmpresarialRepository empresaRepository;


  /**
   * </p>
   * Flux all elements from Mongo passing
   * for reactivate Flux.
   * return all elements from Mono passing
   * for reactivate Flux and return Status OK.
   *
   **/
  @GetMapping(value = "/all")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Empresarial> getAll() {
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
  @GetMapping(value = "/find/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Empresarial> findById(@PathVariable("id")
                                    @NotNull final String id) {
    return empresaRepository.findById(id);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param empresa {@link Empresarial}
   * @return {@link Mono}&lt;{@link Empresarial}&gt;
   * @see String
   * @see Mono
   */
  @PostMapping(path = "/save",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Empresarial> save(@RequestBody @NotNull final Empresarial empresa) {
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
  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> delete(@PathVariable("id") @NotNull final String id) {
    return empresaRepository.deleteById(id);
  }

}
