
package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.FacturaDao;
import com.mycompany.ecolimpio.model.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FacturaDaoImpl implements FacturaDao{
    private Connection conexion;

    public FacturaDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearFactura(Factura factura) throws SQLException {
        String sql = "INSERT INTO factura (idCliente, idServicio, fechaEmision, montoTotal, estadoPago) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, factura.getIdCliente());
            stmt.setInt(2, factura.getIdServicio());
            // Convertir LocalDate a Timestamp (añadiendo la hora a medianoche)
            stmt.setTimestamp(3, Timestamp.valueOf(factura.getFechaEmision().atStartOfDay()));
            stmt.setDouble(4, factura.getMontoTotal());
            stmt.setString(5, factura.getEstadoPago());

            stmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    factura.setIdFactura(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Factura obtenerFactura(int id) throws SQLException {
        String sql = "SELECT * FROM factura WHERE idFactura = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearFactura(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Factura> listarFacturas() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM factura";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                facturas.add(mapearFactura(rs));
            }
        }
        return facturas;
    }

    @Override
    public List<Factura> listarFacturasPorCliente(int idCliente) throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM factura WHERE idCliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    facturas.add(mapearFactura(rs));
                }
            }
        }
        return facturas;
    }

    @Override
    public void actualizarFactura(Factura factura) throws SQLException {
        String sql = "UPDATE factura SET idCliente=?, idServicio=?, fechaEmision=?, montoTotal=?, estadoPago=? WHERE idFactura=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, factura.getIdCliente());
            stmt.setInt(2, factura.getIdServicio());
            // Convertir LocalDate a Timestamp
            stmt.setTimestamp(3, Timestamp.valueOf(factura.getFechaEmision().atStartOfDay()));
            stmt.setDouble(4, factura.getMontoTotal());
            stmt.setString(5, factura.getEstadoPago());
            stmt.setInt(6, factura.getIdFactura());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarFactura(int id) throws SQLException {
        String sql = "DELETE FROM factura WHERE idFactura = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto Factura
    private Factura mapearFactura(ResultSet rs) throws SQLException {
        Factura f = new Factura();
        f.setIdFactura(rs.getInt("idFactura"));
        f.setIdCliente(rs.getInt("idCliente"));
        f.setIdServicio(rs.getInt("idServicio"));
        // Convertir Timestamp a LocalDate
        f.setFechaEmision(rs.getTimestamp("fechaEmision").toLocalDateTime().toLocalDate());
        f.setMontoTotal(rs.getDouble("montoTotal"));
        f.setEstadoPago(rs.getString("estadoPago"));
        return f;
    }
}
