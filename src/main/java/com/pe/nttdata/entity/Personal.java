package com.pe.nttdata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pe.nttdata.domain.BaseDomain;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *Implement Personal. <br/>
 *<b>Class</b>: {@link Personal}<br/>
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
@Document(collection = "Personal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Personal extends BaseDomain implements Serializable {

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
  private String catalog;

  /**
   *.
   **/
  private String descrip;

  /**
   *.
   **/
  private Integer maxMoviento;

  /**
   *.
   **/
  private BigDecimal montoTotal;

  /**
   *.
   **/
  private Pasivo pasivo;


}
