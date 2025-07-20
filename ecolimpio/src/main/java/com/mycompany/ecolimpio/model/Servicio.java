/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Servicio {

    private int idServicio;
    private Cliente cliente;
    private Tecnico tecnico;
    private String tipo;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaProgramada;
    private String estado;
    private int calificacion;

}
