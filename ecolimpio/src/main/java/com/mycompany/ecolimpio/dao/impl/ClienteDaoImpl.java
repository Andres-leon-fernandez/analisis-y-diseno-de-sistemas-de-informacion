package com.mycompany.ecolimpio.dao.impl;

import com.mycompany.ecolimpio.dao.interfaces.ClienteDao;
import com.mycompany.ecolimpio.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private Connection conexion;

    public ClienteDaoImpl() {
    }

    public ClienteDaoImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "insert into cliente (nombreCompleto,email,telefono,direccion,fechaRegistro) Values (?,?,?,?,?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNombreCompleto());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setDate(5, java.sql.Date.valueOf(cliente.getfechaRegistro()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setIdCliente(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("error al crear cliente" + e.getMessage());
        }
    }

    @Override
    public Cliente obtenerCliente(int id) throws SQLException {
        String sql = "select * from cliente where idCliente=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setfechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                    return cliente;
                }
            }
        } catch (SQLException e) {
            System.err.println("error al obtener cliente" + e.getMessage());
            throw e;
        }
        return null;
    }

    @Override
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> listaC = new ArrayList<>();
        String sql = "select*from cliente";
        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setfechaRegistro(rs.getDate("fechaRegistro").toLocalDate());

                listaC.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return listaC;
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nombreCompleto = ?, email = ?, telefono = ?, direccion = ?, fechaRegistro = ? WHERE idCliente = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombreCompleto());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setDate(5, java.sql.Date.valueOf(cliente.getfechaRegistro()));
            stmt.setInt(6, cliente.getIdCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void eliminarCliente(int idCliente) throws SQLException {
         String sql = "DELETE FROM cliente WHERE idCliente = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idCliente);
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al eliminar cliente: " + e.getMessage());
        throw e;
    }
    }

}
