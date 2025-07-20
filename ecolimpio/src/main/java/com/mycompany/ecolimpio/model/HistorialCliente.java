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
public class HistorialCliente {

    private long idHistorial;
    private Cliente Cliente;
    private Servicio Servicio;
    private LocalDateTime fechaHoraRegistro;
    private String tipoInteraccion;
    private String descripcion;

}
