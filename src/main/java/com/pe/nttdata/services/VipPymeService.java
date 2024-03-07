package com.pe.nttdata.services;

import com.pe.nttdata.commons.ProductoEnum;
import com.pe.nttdata.entity.Activo;
import com.pe.nttdata.entity.Empresarial;
import com.pe.nttdata.entity.Moviento;
import com.pe.nttdata.entity.Personal;
import com.pe.nttdata.util.MapperUtils;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

  private Personal personaReturn  = Personal.builder().build();
  private Empresarial empresaReturn  = Empresarial.builder().build();


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
  public Mono<Personal> saveVipVerify(Personal personal) {
    return bancoService.checkExitPersonalCtaRest(personal.getDni())
              .map(activo -> MapperUtils.mapper(Activo.class, activo))
               .flatMap(req -> {
                 if ((req.getTarjeta().getMontoTotal().compareTo(new BigDecimal("500")) > 0)
                         && req.getTypeCliente().equals(ProductoEnum.VIP.getValue())
                         && req.getStatus().equals("PERSONAL-OFF")) {
                   personaReturn = Personal.builder().build();
                   personaReturn.setType(req.getType());
                   personaReturn.setTypeCliente(req.getTypeCliente());
                   personaReturn.setMaxMoviento(req.getMaxMoviento());
                   return bancoService.updateStatusActivo(req.getId().toString())
                           .flatMap(f -> {
                             req.setStatus(f.getStatus());
                             personaReturn.setActivo(req);
                             return personalService.save(personaReturn);
                           });
                 }

                 personaReturn = Personal.builder().build();
                 personaReturn.setDescrip("The client has a bank account type "
                         + req.getTarjeta().getType());
                 return Mono.just(personaReturn);
               }).onErrorResume(error -> {
                 Personal p = Personal.builder().build();
                 p.setDescrip("The user does not have an account created."
                         + error);
                 return Mono.just(p);
               }).switchIfEmpty(Mono.defer(() -> {
                 personaReturn = Personal.builder().build();
                 personaReturn.setDescrip("The document entered does not contain an account");
                 return Mono.just(personaReturn);
               }));

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
  public Mono<Empresarial> savePymeVerify(Empresarial empresarial) {
      return bancoService.checkExitEmpresarialCtaRest(empresarial.getRuc())
              .map(activo -> MapperUtils.mapper(Activo.class, activo))
              .flatMap(req -> {
                  if (req.getTypeCliente().equals(ProductoEnum.PYME.getValue())
                          && req.getStatus().equals("BUSSNESS-OFF")) {

                      empresaReturn = Empresarial.builder().build();
                      empresaReturn.setType(req.getType());

                      return bancoService.updateStatusActivo(req.getId().toString())
                              .flatMap(f -> {
                                  req.setStatus(f.getStatus());
                                  empresaReturn.setActivo(req);
                                  return empresarialService.save(empresaReturn);
                              });
                  }

                  empresaReturn = Empresarial.builder().build();
                  empresaReturn.setDescrip("The client has a bank account type "
                          + req.getTarjeta().getType());
                  return Mono.just(empresaReturn);
              }).onErrorResume(error -> {
                  empresaReturn = Empresarial.builder().build();
                  empresaReturn.setDescrip("The user does not have an account created."
                          + error);
                  return Mono.just(empresaReturn);
              }).switchIfEmpty(Mono.defer(() -> {
                  empresaReturn = Empresarial.builder().build();
                  empresaReturn.setDescrip("The document entered does not contain an account");
                  return Mono.just(empresaReturn);
              }));

  }

    /**
     * <p/>
     * Flux all elements from Mongo passing for
     * reactivate Flux passing the id as a parameter.
     *
     * @return {@link Flux}&lt;{@link Moviento}&gt;
     * @see String
     * @see Flux
     */
    public Flux<Moviento> getAllMovientoBank(){
        return bancoService.getAllMovBank();

    }

}