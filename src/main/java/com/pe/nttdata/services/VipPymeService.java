package com.pe.nttdata.services;

import com.pe.nttdata.commons.ProductoEnum;
import com.pe.nttdata.entity.Empresarial;
import com.pe.nttdata.entity.Personal;
import com.pe.nttdata.util.MapperUtils;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


/**
 *Implement VipPymeService. <br/>
 *<b>Class</b>: {@link VipPymeService}<br/>
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
public class VipPymeService {

  /**
   * .
   * EmpresarialService empresarialService
   **/
  @Autowired
  private EmpresarialService empresarialService;

  /**
   * .
   * PersonalService personalService
   **/
  @Autowired
  private PersonalService personalService;


  /**
   * .
   * BancoService bancoService
   **/
  @Autowired
  private BancoService bancoService;




  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param personal {@link Empresarial}
   * @return {@link Mono}&lt;{@link Personal}&gt;
   * @see String
   * @see Mono
   */
  public Mono<Personal> saveVipAndVerify(Personal personal) {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    return bancoService.aperturaCtaRestCall(personal.getPasivo())
       .map(person -> MapperUtils.mapper(Personal.class, person))
            .flatMap(req -> {
              if (req.getCatalog().equals("402")//isExist
                  && (req.getMontoTotal().compareTo(new BigDecimal("500"))>0)
                  && req.getTypeCliente().equals(ProductoEnum.VIP.getValue())
              ) {

                return Mono.from(personalService.findAll()
                        .map(m -> MapperUtils.mapper(Personal.class, m))
                        .flatMap(r -> {
                          return personalService.save(personal);
                        })).switchIfEmpty(personalService.save(personal));

              }
              return Mono.just(req);
            }).onErrorResume(error->{
                Personal p = Personal.builder().build();
                p.setDescrip("The user does not have an account created.");
                return Mono.just(p); });
  }



}