package com.pe.nttdata.business;

import com.pe.nttdata.model.entity.Empresarial;
import com.pe.nttdata.model.entity.Moviento;
import com.pe.nttdata.model.entity.Personal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Interface VipPymeService. <br/>
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
 *<li>Mar. 8, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
public interface VipPymeService {

  public Mono<Personal> saveVipVerify(Personal personal);

  public Mono<Empresarial> savePymeVerify(Empresarial empresarial);

  public Flux<Moviento> getAllMovientoBank();

}
