
package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.TecnicoDao;
import com.mycompany.ecolimpio.model.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TecnicoDaoImpl implements TecnicoDao{
    private Connection conexion;

    public TecnicoDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearTecnico(Tecnico tecnico) throws SQLException {
        String sql = "INSERT INTO tecnico (nombre, apellido, especialidad, telefono, email, fechaContratacion, activo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tecnico.getNombre());
            stmt.setString(2, tecnico.getApellido());
            stmt.setString(3, tecnico.getEspecialidad());
            stmt.setString(4, tecnico.getTelefono());
            stmt.setString(5, tecnico.getEmail());
            // Convertir LocalDate a Timestamp (añadiendo la hora a medianoche)
            stmt.setTimestamp(6, Timestamp.valueOf(tecnico.getFechaContratacion().atStartOfDay()));
            stmt.setBoolean(7, tecnico.isActivo());

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tecnico.setIdTecnico(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Tecnico obtenerTecnico(int id) throws SQLException {
        String sql = "SELECT * FROM tecnico WHERE idTecnico = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearTecnico(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Tecnico> listarTecnicos() throws SQLException {
        List<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM tecnico";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tecnicos.add(mapearTecnico(rs));
            }
        }
        return tecnicos;
    }

    @Override
    public List<Tecnico> listarTecnicosPorEspecialidad(String especialidad) throws SQLException {
        List<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM tecnico WHERE especialidad = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, especialidad);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tecnicos.add(mapearTecnico(rs));
                }
            }
        }
        return tecnicos;
    }

    @Override
    public void actualizarTecnico(Tecnico tecnico) throws SQLException {
        String sql = "UPDATE tecnico SET nombre=?, apellido=?, especialidad=?, telefono=?, email=?, fechaContratacion=?, activo=? WHERE idTecnico=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, tecnico.getNombre());
            stmt.setString(2, tecnico.getApellido());
            stmt.setString(3, tecnico.getEspecialidad());
            stmt.setString(4, tecnico.getTelefono());
            stmt.setString(5, tecnico.getEmail());
            // Convertir LocalDate a Timestamp
            stmt.setTimestamp(6, Timestamp.valueOf(tecnico.getFechaContratacion().atStartOfDay()));
            stmt.setBoolean(7, tecnico.isActivo());
            stmt.setInt(8, tecnico.getIdTecnico());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarTecnico(int id) throws SQLException {
        String sql = "DELETE FROM tecnico WHERE idTecnico = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto Tecnico
    private Tecnico mapearTecnico(ResultSet rs) throws SQLException {
        Tecnico t = new Tecnico();
        t.setIdTecnico(rs.getInt("idTecnico"));
        t.setNombre(rs.getString("nombre"));
        t.setApellido(rs.getString("apellido"));
        t.setEspecialidad(rs.getString("especialidad"));
        t.setTelefono(rs.getString("telefono"));
        t.setEmail(rs.getString("email"));
        // Convertir Timestamp a LocalDate
        t.setFechaContratacion(rs.getTimestamp("fechaContratacion").toLocalDateTime().toLocalDate());
        t.setActivo(rs.getBoolean("activo"));
        return t;
    }
}
