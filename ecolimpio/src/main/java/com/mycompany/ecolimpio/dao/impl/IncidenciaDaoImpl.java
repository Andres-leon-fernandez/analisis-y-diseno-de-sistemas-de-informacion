package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.IncidenciaDao;
import com.mycompany.ecolimpio.model.Incidencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDaoImpl implements IncidenciaDao {

    private Connection conexion;

    public IncidenciaDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearIncidencia(Incidencia incidencia) throws SQLException {
        String sql = "INSERT INTO incidencia (idServicio, idCliente, idTecnico, tipoIncidencia, descripcion, fechaHoraReporte, estado, prioridad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Manejar IDs que pueden ser NULL en la DB
            if (incidencia.getIdServicio() > 0) {
                stmt.setInt(1, incidencia.getIdServicio());
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }
            if (incidencia.getIdCliente() > 0) {
                stmt.setInt(2, incidencia.getIdCliente());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (incidencia.getIdTecnico() > 0) {
                stmt.setInt(3, incidencia.getIdTecnico());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            stmt.setString(4, incidencia.getTipoIncidencia());
            stmt.setString(5, incidencia.getDescripcion());
            stmt.setTimestamp(6, Timestamp.valueOf(incidencia.getFechaHoraReporte()));
            stmt.setString(7, incidencia.getEstado());
            stmt.setString(8, incidencia.getPrioridad());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    incidencia.setIdIncidencia(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public Incidencia obtenerIncidencia(int id) throws SQLException {
        String sql = "SELECT * FROM incidencia WHERE idIncidencia = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearIncidencia(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Incidencia> listarIncidencias() throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencia ORDER BY fechaHoraReporte DESC"; // Ordenar por fecha de reporte
        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                incidencias.add(mapearIncidencia(rs));
            }
        }
        return incidencias;
    }

    @Override
    public List<Incidencia> listarIncidenciasPorEstado(String estado) throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencia WHERE estado = ? ORDER BY fechaHoraReporte DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    incidencias.add(mapearIncidencia(rs));
                }
            }
        }
        return incidencias;
    }

    @Override
    public List<Incidencia> listarIncidenciasPorCliente(int idCliente) throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencia WHERE idCliente = ? ORDER BY fechaHoraReporte DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    incidencias.add(mapearIncidencia(rs));
                }
            }
        }
        return incidencias;
    }

    @Override
    public List<Incidencia> listarIncidenciasPorServicio(int idServicio) throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencia WHERE idServicio = ? ORDER BY fechaHoraReporte DESC";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idServicio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    incidencias.add(mapearIncidencia(rs));
                }
            }
        }
        return incidencias;
    }

    @Override
    public void actualizarIncidencia(Incidencia incidencia) throws SQLException {
        String sql = "UPDATE incidencia SET idServicio=?, idCliente=?, idTecnico=?, tipoIncidencia=?, descripcion=?, fechaHoraReporte=?, estado=?, prioridad=? WHERE idIncidencia=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            if (incidencia.getIdServicio() > 0) {
                stmt.setInt(1, incidencia.getIdServicio());
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER);
            }
            if (incidencia.getIdCliente() > 0) {
                stmt.setInt(2, incidencia.getIdCliente());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }
            if (incidencia.getIdTecnico() > 0) {
                stmt.setInt(3, incidencia.getIdTecnico());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }
            stmt.setString(4, incidencia.getTipoIncidencia());
            stmt.setString(5, incidencia.getDescripcion());
            stmt.setTimestamp(6, Timestamp.valueOf(incidencia.getFechaHoraReporte()));
            stmt.setString(7, incidencia.getEstado());
            stmt.setString(8, incidencia.getPrioridad());
            stmt.setInt(9, incidencia.getIdIncidencia());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminarIncidencia(int id) throws SQLException {
        String sql = "DELETE FROM incidencia WHERE idIncidencia = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método auxiliar para mapear un ResultSet a un objeto Incidencia
    private Incidencia mapearIncidencia(ResultSet rs) throws SQLException {
        Incidencia i = new Incidencia();
        i.setIdIncidencia(rs.getInt("idIncidencia"));

        // Manejar IDs que pueden ser NULL en la DB
        int idServicio = rs.getInt("idServicio");
        if (rs.wasNull()) {
            i.setIdServicio(0);
        } else {
            i.setIdServicio(idServicio);
        }

        int idCliente = rs.getInt("idCliente");
        if (rs.wasNull()) {
            i.setIdCliente(0);
        } else {
            i.setIdCliente(idCliente);
        }

        int idTecnico = rs.getInt("idTecnico");
        if (rs.wasNull()) {
            i.setIdTecnico(0);
        } else {
            i.setIdTecnico(idTecnico);
        }

        i.setTipoIncidencia(rs.getString("tipoIncidencia"));
        i.setDescripcion(rs.getString("descripcion"));
        i.setFechaHoraReporte(rs.getTimestamp("fechaHoraReporte").toLocalDateTime());
        i.setEstado(rs.getString("estado"));
        i.setPrioridad(rs.getString("prioridad"));
        return i;
    }
}
