package com.pe.nttdata.services;

import com.pe.nttdata.entity.Activo;
import com.pe.nttdata.entity.Moviento;
import com.pe.nttdata.entity.Pasivo;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *Interface BancoService. <br/>
 *<b>Class</b>: {@link BancoService}<br/>
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
public interface BancoService {

  public Mono<Activo> checkExitPersonalCtaRest(@RequestBody @NotNull String dni);

  public Mono<Activo> checkExitEmpresarialCtaRest(@RequestBody @NotNull String ruc);

  public Mono<Activo> updateStatusActivo(@RequestBody @NotNull String id);

  public Flux<Moviento> getAllMovBank();

  public Mono<Pasivo> aperturaBusinessCtaRest(@RequestBody @NotNull Activo activo);

}
