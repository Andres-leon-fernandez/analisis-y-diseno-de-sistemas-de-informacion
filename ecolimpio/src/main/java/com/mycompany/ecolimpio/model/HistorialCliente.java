package com.mycompany.ecolimpio.model;

import java.time.LocalDateTime;

public class HistorialCliente {

    private int idHistorial;
    private int idCliente;
    private int idServicio;
    private LocalDateTime fechaHoraInteraccion;
    private String tipoInteraccion;
    private String descripcion;

    public HistorialCliente() {
    }

    public HistorialCliente(int idHistorial, int idCliente, int idServicio, LocalDateTime fechaHoraInteraccion, String tipoInteraccion, String descripcion) {
        this.idHistorial = idHistorial;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fechaHoraInteraccion = fechaHoraInteraccion;
        this.tipoInteraccion = tipoInteraccion;
        this.descripcion = descripcion;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDateTime getFechaHoraInteraccion() {
        return fechaHoraInteraccion;
    }

    public void setFechaHoraInteraccion(LocalDateTime fechaHoraInteraccion) {
        this.fechaHoraInteraccion = fechaHoraInteraccion;
    }

    public String getTipoInteraccion() {
        return tipoInteraccion;
    }

    public void setTipoInteraccion(String tipoInteraccion) {
        this.tipoInteraccion = tipoInteraccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
