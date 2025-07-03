
package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.HistorialClienteDao;
import com.mycompany.ecolimpio.model.HistorialCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HistorialClienteDaoImpl implements HistorialClienteDao {

    private Connection conexion;

    public HistorialClienteDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearHistorialCliente(HistorialCliente historial) throws SQLException {
        String sql = "INSERT INTO historial_cliente (idCliente, idServicio, fechaHoraInteraccion, tipoInteraccion, descripcion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, historial.getIdCliente());
            // Si idServicio es opcional y puede ser null, deberías manejarlo.
            // Para este ejemplo, asumimos que siempre tiene un valor o se setea a NULL si no aplica.
            if (historial.getIdServicio() > 0) { // Asumiendo que 0 o algún valor negativo indica "no asociado"
                stmt.setInt(2, historial.getIdServicio());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            
            // Usamos LocalDateTime directamente para Timestamp.valueOf()
            stmt.setTimestamp(3, Timestamp.valueOf(historial.getFechaHoraInteraccion()));
            stmt.setString(4, historial.getTipoInteraccion());
            stmt.setString(5, historial.getDescripcion());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    historial.setIdHistorial(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public HistorialCliente obtenerHistorialCliente(int id) throws SQLException {
        String sql = "SELECT * FROM historial_cliente WHERE idHistorial = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearHistorialCliente(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<HistorialCliente> listarHistorialesCliente() throws SQLException {
        List<HistorialCliente> historiales = new ArrayList<>();
        String sql = "SELECT * FROM historial_cliente ORDER BY fechaHoraInteraccion DESC"; // Ordenar por fecha para mejor visualización
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                historiales.add(mapearHistorialCliente(rs));
            }
        }
        return historiales;
    }

    @Override
    public List<HistorialCliente> listarHistorialPorCliente(int idCliente) throws SQLException {
        List<HistorialCliente> historiales = new ArrayList<>();
        String sql = "SELECT * FROM historial_cliente WHERE idCliente = ? ORDER BY fechaHoraInteraccion DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    historiales.add(mapearHistorialCliente(rs));
                }
            }
        }
        return historiales;
    }

    @Override
    public void actualizarHistorialCliente(HistorialCliente historial) throws SQLException {
        String sql = "UPDATE historial_cliente SET idCliente=?, idServicio=?, fechaHoraInteraccion=?, tipoInteraccion=?, descripcion=? WHERE idHistorial=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, historial.getIdCliente());
            if (historial.getIdServicio() > 0) {
                stmt.setInt(2, historial.getIdServicio());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            stmt.setTimestamp(3, Timestamp.valueOf(historial.getFechaHoraInteraccion()));
            stmt.setString(4, historial.getTipoInteraccion());
            stmt.setString(5, historial.getDescripcion());
            stmt.setInt(6, historial.getIdHistorial());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarHistorialCliente(int id) throws SQLException {
        String sql = "DELETE FROM historial_cliente WHERE idHistorial = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto HistorialCliente
    private HistorialCliente mapearHistorialCliente(ResultSet rs) throws SQLException {
        HistorialCliente hc = new HistorialCliente();
        hc.setIdHistorial(rs.getInt("idHistorial"));
        hc.setIdCliente(rs.getInt("idCliente"));
        
        // Manejar idServicio que puede ser NULL en la DB
        int idServicio = rs.getInt("idServicio");
        if (rs.wasNull()) { // Verifica si el último valor leído fue NULL
            hc.setIdServicio(0); // O cualquier valor que uses para indicar "sin servicio asociado"
        } else {
            hc.setIdServicio(idServicio);
        }
        
        // LocalDateTime se puede obtener directamente de Timestamp
        hc.setFechaHoraInteraccion(rs.getTimestamp("fechaHoraInteraccion").toLocalDateTime());
        hc.setTipoInteraccion(rs.getString("tipoInteraccion"));
        hc.setDescripcion(rs.getString("descripcion"));
        return hc;
    }
}