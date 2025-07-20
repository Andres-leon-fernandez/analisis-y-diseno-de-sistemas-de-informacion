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
public class Notificacion {

    private long idNotificacion;
    private Cliente Cliente;
    private Tecnico Tecnico;
    private Administrador Administrador;
    private String mensaje;
    private LocalDateTime fechaHoraNotificacion;
    private boolean leida;
}
