package com.pe.nttdata.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pe.nttdata.model.domain.BaseDomain;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "Activo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activo  extends BaseDomain implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   *.
   **/
  @Id
  @JsonSerialize(using = NoObjectIdSerializer.class)
  private ObjectId id;

  /**
   *.
   **/
  private String type;

  /**
   *.
   **/
  private String typeCliente;

  /**
   *.
   **/
  private String status;

  /**
   *.
   **/
  private Integer maxMoviento;


  /**
   *.
   **/
  private String descrip;

  /**
   *.
   **/
  private Persona persona;

  /**
   *.
   **/
  private Empresa empresa;

  /**
   *.
   **/
  private TarjetaCredito tarjeta;

}
