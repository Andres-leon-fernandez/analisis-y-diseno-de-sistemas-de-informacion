
package com.mycompany.ecolimpio.model;

import java.time.LocalDate;

public class Cliente {
    private int idCliente;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDate fechaRegistro;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCompleto, String email, String telefono, String direccion, LocalDate fechaRegistro) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String celular) {
        this.telefono = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }

    public void setfechaRegistro(LocalDate fecha) {
        this.fechaRegistro = fecha;
    }
}
