package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.NotificacionDAOImpl;
import com.mycompany.ecolimpio.dao.Impl.ServicioDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.ServicioDAO;
import com.mycompany.ecolimpio.model.Notificacion;
import com.mycompany.ecolimpio.model.Servicio;

import java.util.List;

public class ServicioService {
    private final ServicioDAO servicioDAO = new ServicioDAOImpl();

    public void registrar(Servicio servicio) {

        servicioDAO.guardar(servicio);
    }

    public void actualizar(Servicio servicio) {

        servicioDAO.actualizar(servicio);
    }

    public void eliminar(Long id) {
        servicioDAO.eliminar(id);
    }

    public List<Servicio> listarTodos() {
        return servicioDAO.listarTodos();
    }

    public Servicio listarPorId(Long id) {

        return servicioDAO.buscarPorId(id);
    }
}
