package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.AdministradorDao;
import com.mycompany.ecolimpio.model.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AdministradorDaoImpl implements AdministradorDao {

    private Connection conexion;

    public AdministradorDaoImpl() {
    }

    public AdministradorDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearAdministrador(Administrador administrador) throws SQLException {
        String sql = "INSERT INTO administrador (nombreUsuario, email, contrasena, fechaCreacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, administrador.getNombreUsuario());
            stmt.setString(2, administrador.getEmail());
            stmt.setString(3, administrador.getContrasena());
            // Convertir LocalDate a Timestamp (añadiendo la hora a medianoche)
            stmt.setTimestamp(4, Timestamp.valueOf(administrador.getFechaCreacion().atStartOfDay()));

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    administrador.setIdAdministrador(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Administrador obtenerAdministrador(int id) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE idAdministrador = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearAdministrador(rs);
                }
            }
        }
        return null;
    }

    @Override
    public Administrador obtenerAdministradorPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE email = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearAdministrador(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Administrador> listarAdministradores() throws SQLException {
        List<Administrador> administradores = new ArrayList<>();
        String sql = "SELECT * FROM administrador";
        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                administradores.add(mapearAdministrador(rs));
            }
        }
        return administradores;
    }

    @Override
    public void actualizarAdministrador(Administrador administrador) throws SQLException {
        String sql = "UPDATE administrador SET nombreUsuario=?, email=?, contrasena=?, fechaCreacion=? WHERE idAdministrador=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, administrador.getNombreUsuario());
            stmt.setString(2, administrador.getEmail());
            stmt.setString(3, administrador.getContrasena());
            // Convertir LocalDate a Timestamp
            stmt.setTimestamp(4, Timestamp.valueOf(administrador.getFechaCreacion().atStartOfDay()));
            stmt.setInt(5, administrador.getIdAdministrador());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarAdministrador(int id) throws SQLException {
        String sql = "DELETE FROM administrador WHERE idAdministrador = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto Administrador
    private Administrador mapearAdministrador(ResultSet rs) throws SQLException {
        Administrador a = new Administrador();
        a.setIdAdministrador(rs.getInt("idAdministrador"));
        a.setNombreUsuario(rs.getString("nombreUsuario"));
        a.setEmail(rs.getString("email"));
        a.setContrasena(rs.getString("contrasena"));
        // Convertir Timestamp a LocalDate
        a.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime().toLocalDate());
        return a;
    }

}
