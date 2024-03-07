package com.pe.nttdata.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AppProcesoLogDto {

    private Date fechaInicioEjecucion;
    private Date fechaFinEjecucion;
    private String estadoEjecucion;
    private String descripcionEstadoEjecucion;
    private String modulo;
    private String claseProgramacion;
    private String metodoProgramacion;
    private String parametroEntrada;
    private String resultadoSalida;
    private Integer duracionMs;

}
