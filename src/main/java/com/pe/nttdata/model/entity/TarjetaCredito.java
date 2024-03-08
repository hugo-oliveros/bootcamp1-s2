package com.pe.nttdata.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pe.nttdata.model.domain.BaseDomain;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(collection = "Activos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TarjetaCredito extends BaseDomain implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @JsonSerialize(using = NoObjectIdSerializer.class)
    private ObjectId id;
    private String type;
    private BigDecimal montoConsumed;
    private BigDecimal montoTotal;
    private String numberAccount;

}
