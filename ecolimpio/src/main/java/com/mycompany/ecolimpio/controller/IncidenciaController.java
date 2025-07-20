package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.FacturaService;
import com.mycompany.ecolimpio.Service.IncidenciaService;
import com.mycompany.ecolimpio.model.Factura;
import com.mycompany.ecolimpio.model.Incidencia;

import java.util.List;

public class IncidenciaController {
    private final IncidenciaService incidenciaService = new IncidenciaService();

    public void registrarIncidencia(Incidencia inc) {
        incidenciaService.registrar(inc);
    }

    public void actualizarIncidencia(Incidencia inc) {
        incidenciaService.actualizar(inc);
    }

    public void eliminarIncidencia(Long id) {
        incidenciaService.eliminar(id);
    }

    public List<Incidencia> listarIncidencia() {
        return incidenciaService.listarTodos();
    }

    public Incidencia obtenerIncidencia(Long id) {
        return incidenciaService.listarPorId(id);
    }
}
