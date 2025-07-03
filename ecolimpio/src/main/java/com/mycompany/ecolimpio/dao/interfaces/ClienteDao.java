package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

    public void crearCliente(Cliente cliente) throws SQLException;

    public Cliente obtenerCliente(int id) throws SQLException;

    public List<Cliente> listarClientes() throws SQLException;

    public void actualizarCliente(Cliente cliente) throws SQLException;

    public void eliminarCliente(int idCliente) throws SQLException;
}
