/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.NotificacionDao;
import com.mycompany.ecolimpio.model.Notificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NotificacionDaoImpl implements NotificacionDao {

    private Connection conexion;

    public NotificacionDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearNotificacion(Notificacion notificacion) throws SQLException {
        String sql = "INSERT INTO notificacion (idCliente, idTecnico, idAdministrador, mensaje, fechaHora, leida) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Manejar IDs que pueden ser NULL en la DB si no aplican
            if (notificacion.getIdCliente() > 0) {
                stmt.setInt(1, notificacion.getIdCliente());
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }
            if (notificacion.getIdTecnico() > 0) {
                stmt.setInt(2, notificacion.getIdTecnico());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (notificacion.getIdAdministrador() > 0) {
                stmt.setInt(3, notificacion.getIdAdministrador());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            
            stmt.setString(4, notificacion.getMensaje());
            stmt.setTimestamp(5, Timestamp.valueOf(notificacion.getFechaHora()));
            stmt.setBoolean(6, notificacion.isLeida());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    notificacion.setIdNotificacion(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Notificacion obtenerNotificacion(int id) throws SQLException {
        String sql = "SELECT * FROM notificacion WHERE idNotificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearNotificacion(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Notificacion> listarNotificaciones() throws SQLException {
        List<Notificacion> notificaciones = new ArrayList<>();
        String sql = "SELECT * FROM notificacion ORDER BY fechaHora DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                notificaciones.add(mapearNotificacion(rs));
            }
        }
        return notificaciones;
    }

    @Override
    public List<Notificacion> listarNotificacionesPorCliente(int idCliente) throws SQLException {
        List<Notificacion> notificaciones = new ArrayList<>();
        String sql = "SELECT * FROM notificacion WHERE idCliente = ? ORDER BY fechaHora DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    notificaciones.add(mapearNotificacion(rs));
                }
            }
        }
        return notificaciones;
    }

    @Override
    public List<Notificacion> listarNotificacionesPorTecnico(int idTecnico) throws SQLException {
        List<Notificacion> notificaciones = new ArrayList<>();
        String sql = "SELECT * FROM notificacion WHERE idTecnico = ? ORDER BY fechaHora DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idTecnico);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    notificaciones.add(mapearNotificacion(rs));
                }
            }
            return notificaciones;
        }
    }

    @Override
    public List<Notificacion> listarNotificacionesPorAdministrador(int idAdministrador) throws SQLException {
        List<Notificacion> notificaciones = new ArrayList<>();
        String sql = "SELECT * FROM notificacion WHERE idAdministrador = ? ORDER BY fechaHora DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idAdministrador);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    notificaciones.add(mapearNotificacion(rs));
                }
            }
            return notificaciones;
        }
    }

    @Override
    public void actualizarNotificacion(Notificacion notificacion) throws SQLException {
        String sql = "UPDATE notificacion SET idCliente=?, idTecnico=?, idAdministrador=?, mensaje=?, fechaHora=?, leida=? WHERE idNotificacion=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            if (notificacion.getIdCliente() > 0) {
                stmt.setInt(1, notificacion.getIdCliente());
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }
            if (notificacion.getIdTecnico() > 0) {
                stmt.setInt(2, notificacion.getIdTecnico());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (notificacion.getIdAdministrador() > 0) {
                stmt.setInt(3, notificacion.getIdAdministrador());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            stmt.setString(4, notificacion.getMensaje());
            stmt.setTimestamp(5, Timestamp.valueOf(notificacion.getFechaHora()));
            stmt.setBoolean(6, notificacion.isLeida());
            stmt.setInt(7, notificacion.getIdNotificacion());

            stmt.executeUpdate();
        }
    }

    @Override
    public void marcarComoLeida(int idNotificacion) throws SQLException {
        String sql = "UPDATE notificacion SET leida = TRUE WHERE idNotificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idNotificacion);
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarNotificacion(int id) throws SQLException {
        String sql = "DELETE FROM notificacion WHERE idNotificacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto Notificacion
    private Notificacion mapearNotificacion(ResultSet rs) throws SQLException {
        Notificacion n = new Notificacion();
        n.setIdNotificacion(rs.getInt("idNotificacion"));
        
        // Manejar IDs que pueden ser NULL en la DB
        int idCliente = rs.getInt("idCliente");
        if (rs.wasNull()) { n.setIdCliente(0); } else { n.setIdCliente(idCliente); }

        int idTecnico = rs.getInt("idTecnico");
        if (rs.wasNull()) { n.setIdTecnico(0); } else { n.setIdTecnico(idTecnico); }
        
        int idAdministrador = rs.getInt("idAdministrador");
        if (rs.wasNull()) { n.setIdAdministrador(0); } else { n.setIdAdministrador(idAdministrador); }
        
        n.setMensaje(rs.getString("mensaje"));
        n.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
        n.setLeida(rs.getBoolean("leida"));
        return n;
    }
}