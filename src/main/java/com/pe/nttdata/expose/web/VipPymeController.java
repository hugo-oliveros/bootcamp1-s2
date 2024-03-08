package com.pe.nttdata.expose.web;

import com.pe.nttdata.business.VipPymeService;
import com.pe.nttdata.model.entity.Empresarial;
import com.pe.nttdata.model.entity.Moviento;
import com.pe.nttdata.model.entity.Personal;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *Implement VipPymeController. <br/>
 *<b>Class</b>: {@link VipPymeController}<br/>
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
@RequestMapping("vipyme/api/v1")
@CrossOrigin("*")
@Slf4j
public class VipPymeController {

  /**
   * .
   * VipPymeService vipPymeService
   **/
  @Autowired
  private VipPymeService vipPymeService;

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param personal {@link Personal}
   * @return {@link Mono}&lt;{@link Personal}&gt;
   * @see String
   * @see Mono
   */
  @PostMapping(path = "/saveVip",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Personal> save(@RequestBody @NotNull final Personal personal) {
    return vipPymeService.saveVipVerify(personal);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param empresarial {@link Empresarial}
   * @return {@link Mono}&lt;{@link Personal}&gt;
   * @see String
   * @see Mono
   */
  @PostMapping(path = "/savePyme",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Empresarial> save(@RequestBody @NotNull final Empresarial empresarial) {
    return vipPymeService.savePymeVerify(empresarial);
  }


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Moviento}&gt;
   * @see Moviento
   * @see Flux
   */
  @GetMapping(value = "/allMovBank")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Moviento> getAllMovBack() {
    return vipPymeService.getAllMovientoBank();
  }


  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @return {@link Flux}&lt;{@link Moviento}&gt;
   * @see Moviento
   * @see Flux
   */
  @GetMapping(value = "/totalMovBank")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Moviento> totalMovBank() {
    return vipPymeService.getAllMovientoBank()
            .groupBy(Moviento::getNumberAccount)
            .flatMap(f -> {
              return f;
            });
  }


  public String idReturn(Moviento mov) {
    return mov.getId().toString();
  }

}
