package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.AdministradorService;
import com.mycompany.ecolimpio.Service.HistorialClienteService;
import com.mycompany.ecolimpio.model.Administrador;
import com.mycompany.ecolimpio.model.HistorialCliente;

import java.util.List;

public class HistorialClienteController {

    private final HistorialClienteService historialClienteService = new HistorialClienteService();

    public void registrarHistorial(HistorialCliente hc) {
        historialClienteService.registrar(hc);
    }

    public void actualizarHistorial(HistorialCliente hc) {
        historialClienteService.actualizar(hc);
    }

    public void eliminarHistorial(Long id) {
        historialClienteService.eliminar(id);
    }

    public List<HistorialCliente> listarHistorial() {
        return historialClienteService.listarTodos();
    }

    public HistorialCliente obtenerHistorial(Long id) {
        return historialClienteService.listarPorId(id);
    }
}
