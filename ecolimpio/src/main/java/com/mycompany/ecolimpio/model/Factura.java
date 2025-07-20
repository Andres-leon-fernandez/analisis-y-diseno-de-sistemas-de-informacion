package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    private long idFactura;
    private Cliente Cliente;
    private Servicio Servicio;
    private LocalDateTime fechaHoraEmision;//DATETIME en bd
    private double montoTotal;
    private String estadoPago;
}
