package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.NotificacionService;
import com.mycompany.ecolimpio.Service.ServicioService;
import com.mycompany.ecolimpio.model.Notificacion;
import com.mycompany.ecolimpio.model.Servicio;

import java.util.List;

public class ServicioController {
    private final ServicioService servicioService = new ServicioService();

    public void registrarServicio(Servicio servicio) {
        servicioService.registrar(servicio);
    }

    public void actualizarServicio(Servicio servicio) {
        servicioService.actualizar(servicio);
    }

    public void eliminarServicio(Long id) {
        servicioService.eliminar(id);
    }

    public List<Servicio> listarServicio() {
        return servicioService.listarTodos();
    }

    public Servicio obtenerServicio(Long id) {
        return servicioService.listarPorId(id);
    }
}
