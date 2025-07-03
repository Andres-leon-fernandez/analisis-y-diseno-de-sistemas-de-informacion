package com.mycompany.ecolimpio.model;

import java.time.LocalDate;

public class Administrador {

    private int idAdministrador;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private LocalDate fechaCreacion;

    public Administrador() {
    }

    public Administrador(int idAdministrador, String nombreUsuario, String email, String contrasena, LocalDate fechaCreacion) {
        this.idAdministrador = idAdministrador;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
