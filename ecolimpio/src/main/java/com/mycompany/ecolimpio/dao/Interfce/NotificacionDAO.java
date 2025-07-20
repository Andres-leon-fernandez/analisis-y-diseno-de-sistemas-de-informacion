package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Notificacion;

import java.util.List;

public interface NotificacionDAO {
    void guardar(Notificacion notificacion);

    void actualizar(Notificacion notificacion);

    void eliminar(Long idnotificacion);

    Notificacion buscarPorId(Long idnotificacion);

    List<Notificacion> listarTodos();
}
