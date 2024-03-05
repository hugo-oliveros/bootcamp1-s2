package com.pe.nttdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pe.nttdata.domain.BaseDomain;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "Movimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moviento extends BaseDomain implements Serializable {

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
    private String descrip;

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
    private double moviento;

    /**
     *.
     **/
    private Date fechaMovi;

    /**
     *.
     **/
    private String numberAccount;

    /**
     *.
     **/
    private String lugarMov;
}
