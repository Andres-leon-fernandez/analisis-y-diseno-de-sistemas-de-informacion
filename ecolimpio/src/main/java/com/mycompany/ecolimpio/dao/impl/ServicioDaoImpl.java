package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.ServicioDao;
import java.sql.Connection;
import com.mycompany.ecolimpio.model.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class ServicioDaoImpl implements ServicioDao {

    private Connection conexion;

    public ServicioDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearServicio(Servicio servicio) throws SQLException {
        String sql = "INSERT INTO servicio (idCliente, idTecnico, tipo, fechaSolicitud, fechaProgramada, estado, calificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, servicio.getIdCliente());
            stmt.setInt(2, servicio.getIdTecnico());
            stmt.setString(3, servicio.getTipo());
            stmt.setTimestamp(4, Timestamp.valueOf(servicio.getFechaSolicitud().atStartOfDay()));
            stmt.setTimestamp(5, Timestamp.valueOf(servicio.getFechaProgramada().atStartOfDay()));
            stmt.setString(6, servicio.getEstado());
            stmt.setInt(7, servicio.getCalificacion());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    servicio.setIdServicio(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Servicio obtenerServicio(int id) throws SQLException {
        String sql = "SELECT * FROM servicio WHERE idService = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Servicio s = new Servicio();
                    s.setIdServicio(rs.getInt("idService"));
                    s.setIdCliente(rs.getInt("idCliente"));
                    s.setIdTecnico(rs.getInt("idTecnico"));
                    s.setTipo(rs.getString("tipo"));
                    s.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime().toLocalDate());
                    s.setFechaProgramada(rs.getTimestamp("fechaProgramada").toLocalDateTime().toLocalDate());
                    s.setEstado(rs.getString("estado"));
                    s.setCalificacion(rs.getInt("calificacion"));
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public List<Servicio> listarServicios() throws SQLException {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicio";
        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Servicio s = new Servicio();
                s.setIdServicio(rs.getInt("idService"));
                s.setIdCliente(rs.getInt("idCliente"));
                s.setIdTecnico(rs.getInt("idTecnico"));
                s.setTipo(rs.getString("tipo"));
                s.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime().toLocalDate());
                s.setFechaProgramada(rs.getTimestamp("fechaProgramada").toLocalDateTime().toLocalDate());
                s.setEstado(rs.getString("estado"));
                s.setCalificacion(rs.getInt("calificacion"));
                lista.add(s);
            }
        }
        return lista;
    }

    @Override
    public void actualizarServicio(Servicio servicio) throws SQLException {
        String sql = "UPDATE servicio SET idCliente=?, idTecnico=?, tipo=?, fechaSolicitud=?, fechaProgramada=?, estado=?, calificacion=? WHERE idService=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, servicio.getIdCliente());
            stmt.setInt(2, servicio.getIdTecnico());
            stmt.setString(3, servicio.getTipo());
            stmt.setTimestamp(4, Timestamp.valueOf(servicio.getFechaSolicitud().atStartOfDay()));
            stmt.setTimestamp(5, Timestamp.valueOf(servicio.getFechaProgramada().atStartOfDay()));
            stmt.setString(6, servicio.getEstado());
            stmt.setInt(7, servicio.getCalificacion());
            stmt.setInt(8, servicio.getIdServicio());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarServicio(int id) throws SQLException {
        String sql = "DELETE FROM servicio WHERE idService = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
