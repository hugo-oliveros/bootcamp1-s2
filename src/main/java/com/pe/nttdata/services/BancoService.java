package com.pe.nttdata.services;

import com.pe.nttdata.entity.Activo;
import com.pe.nttdata.entity.Pasivo;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *Implement BancoService. <br/>
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
 *<li>feb. 29, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */
@Service
@Slf4j
public class BancoService {

  /**
   * .
   * WebClient webClient
   **/
  private final WebClient webClient;

  public BancoService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8085").build();
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param dni {@link String}
   * @return {@link Mono}&lt;{@link Activo}&gt;
   * @see Mono
   * @see Activo
   */
  public Mono<Activo> checkExitPersonalCtaRest(@RequestBody @NotNull String dni) {
    return this.webClient.get().uri("/banco/api/v1/findByDNI/{dni}",dni)
            .retrieve()
            .bodyToMono(Activo.class);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param id {@link String}
   * @return {@link Mono}&lt;{@link Activo}&gt;
   * @see Mono
   * @see Activo
   */
  public Mono<Activo> updateStatusActivo(@RequestBody @NotNull String id) {
    return this.webClient.get().uri("/banco/api/v1/updateStatusByid/{id}",id)
            .retrieve()
            .bodyToMono(Activo.class);
  }

  /**
   * <p/>
   * Flux all elements from Mongo passing for
   * reactivate Flux passing the id as a parameter.
   *
   * @param activo {@link Pasivo}
   * @return {@link Mono}&lt;{@link Pasivo}&gt;
   * @see Mono
   * @see Pasivo
   */
  public Mono<Pasivo> aperturaBusinessCtaRest(@RequestBody @NotNull Activo activo) {
    return this.webClient.post().uri("/banco/api/v1/saveBusiness")
            .body(BodyInserters.fromValue(activo))
            .retrieve()
            .bodyToMono(Pasivo.class);
  }
}
