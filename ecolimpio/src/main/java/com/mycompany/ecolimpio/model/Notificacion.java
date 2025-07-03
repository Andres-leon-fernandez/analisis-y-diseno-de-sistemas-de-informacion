package com.mycompany.ecolimpio.model;

import java.time.LocalDateTime;

public class Notificacion {

    private int idNotificacion;
    private int idCliente;
    private int idTecnico;
    private int idAdministrador;
    private String mensaje;
    private LocalDateTime fechaHora;
    private boolean leida;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, int idCliente, int idTecnico, int idAdministrador, String mensaje, LocalDateTime fechaHora, boolean leida) {
        this.idNotificacion = idNotificacion;
        this.idCliente = idCliente;
        this.idTecnico = idTecnico;
        this.idAdministrador = idAdministrador;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.leida = leida;
    }

    // Getters y Setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }
}
