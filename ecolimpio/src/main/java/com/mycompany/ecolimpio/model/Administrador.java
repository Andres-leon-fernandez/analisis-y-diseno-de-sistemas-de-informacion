package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    private long idAdministrador;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private LocalDate fechaCreacion;

    @Builder
    public Administrador(String nombreUsuario, String email, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
    }

}
