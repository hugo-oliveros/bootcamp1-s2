package com.pe.nttdata.services;

import com.pe.nttdata.entity.Personal;
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


  public Mono<Personal> saveAndVerify(Personal personal) {
    bancoService.someRestCall("save");
    return personalService.save(personal);
  }


}