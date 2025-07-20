package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.IncidenciaService;
import com.mycompany.ecolimpio.Service.NotificacionService;
import com.mycompany.ecolimpio.model.Incidencia;
import com.mycompany.ecolimpio.model.Notificacion;

import java.util.List;

public class NotificacionController {
    private final NotificacionService notificacionService = new NotificacionService();

    public void registrarNotificacion(Notificacion not) {
        notificacionService.registrar(not);
    }

    public void actualizarNotificacion(Notificacion not) {
        notificacionService.actualizar(not);
    }

    public void eliminarNotificacion(Long id) {
        notificacionService.eliminar(id);
    }

    public List<Notificacion> listarNotificacion() {
        return notificacionService.listarTodos();
    }

    public Notificacion obtenerNotificacion(Long id) {
        return notificacionService.listarPorId(id);
    }
}
