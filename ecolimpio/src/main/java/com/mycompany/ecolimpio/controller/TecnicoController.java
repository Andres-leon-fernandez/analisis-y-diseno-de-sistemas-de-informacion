package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.ServicioService;
import com.mycompany.ecolimpio.Service.TecnicoService;
import com.mycompany.ecolimpio.model.Servicio;
import com.mycompany.ecolimpio.model.Tecnico;

import java.util.List;

public class TecnicoController {
    private final TecnicoService tecnicoService = new TecnicoService();

    public void registrarTecnico(Tecnico tecnico) {
        tecnicoService.registrar(tecnico);
    }

    public void actualizarTecnico(Tecnico tecnico) {
        tecnicoService.actualizar(tecnico);
    }

    public void eliminarTecnico(Long id) {
        tecnicoService.eliminar(id);
    }

    public List<Tecnico> listarTecnico() {
        return tecnicoService.listarTodos();
    }

    public Tecnico obtenerTecnico(Long id) {
        return tecnicoService.listarPorId(id);
    }
}
