package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.NotificacionDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.NotificacionDAO;
import com.mycompany.ecolimpio.model.Notificacion;

import java.util.List;

public class NotificacionService {
    private final NotificacionDAO notificacionDAO = new NotificacionDAOImpl();

    public void registrar(Notificacion not) {

        notificacionDAO.guardar(not);
    }

    public void actualizar(Notificacion not) {

        notificacionDAO.actualizar(not);
    }

    public void eliminar(Long id) {
        notificacionDAO.eliminar(id);
    }

    public List<Notificacion> listarTodos() {
        return notificacionDAO.listarTodos();
    }

    public Notificacion listarPorId(Long id) {

        return notificacionDAO.buscarPorId(id);
    }
}
