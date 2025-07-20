package com.mycompany.ecolimpio.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incidencia {

    private long idIncidencia;
    private Servicio Servicio;
    private Cliente Cliente;
    private Tecnico Tecnico;
    private String tipoIncidencia;
    private String descripcion;
    private LocalDateTime fechaHoraReporte;
    private String estado;
    private String prioridad;

}
