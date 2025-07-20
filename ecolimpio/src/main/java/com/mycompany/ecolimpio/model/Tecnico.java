package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {

    private long idTecnico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
    private LocalDate fechaContratacion;
    private boolean activo;

}
