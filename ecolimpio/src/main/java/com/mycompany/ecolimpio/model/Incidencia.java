package com.mycompany.ecolimpio.model;

import java.time.LocalDateTime;

public class Incidencia {

    private int idIncidencia;
    private int idServicio;
    private int idCliente;
    private int idTecnico;
    private String tipoIncidencia;
    private String descripcion;
    private LocalDateTime fechaHoraReporte;
    private String estado;
    private String prioridad;

    public Incidencia() {
    }

    public Incidencia(int idIncidencia, int idServicio, int idCliente, int idTecnico, String tipoIncidencia, String descripcion, LocalDateTime fechaHoraReporte, String estado, String prioridad) {
        this.idIncidencia = idIncidencia;
        this.idServicio = idServicio;
        this.idCliente = idCliente;
        this.idTecnico = idTecnico;
        this.tipoIncidencia = tipoIncidencia;
        this.descripcion = descripcion;
        this.fechaHoraReporte = fechaHoraReporte;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    public void setFechaHoraReporte(LocalDateTime fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
