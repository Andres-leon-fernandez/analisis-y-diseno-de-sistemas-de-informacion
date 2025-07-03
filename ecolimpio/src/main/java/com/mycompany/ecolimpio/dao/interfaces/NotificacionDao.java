/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Notificacion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andres
 */
public interface NotificacionDao {

    void crearNotificacion(Notificacion notificacion) throws SQLException;

    Notificacion obtenerNotificacion(int id) throws SQLException;

    List<Notificacion> listarNotificaciones() throws SQLException;

    List<Notificacion> listarNotificacionesPorCliente(int idCliente) throws SQLException;

    List<Notificacion> listarNotificacionesPorTecnico(int idTecnico) throws SQLException;

    List<Notificacion> listarNotificacionesPorAdministrador(int idAdministrador) throws SQLException;

    void actualizarNotificacion(Notificacion notificacion) throws SQLException;

    void marcarComoLeida(int idNotificacion) throws SQLException;

    void eliminarNotificacion(int id) throws SQLException;
}
