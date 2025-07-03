
package com.mycompany.ecolimpio.model;

import java.time.LocalDate;

public class Factura {
    private int idFactura;
    private int idCliente;
    private int idServicio;
    private LocalDate fechaEmision;
    private double montoTotal;
    private String estadoPago; 

    public Factura() {
    }

    public Factura(int idFactura, int idCliente, int idServicio, LocalDate fechaEmision, double montoTotal, String estadoPago) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.estadoPago = estadoPago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    
}
