package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Cliente;

import java.util.List;

public interface ClienteDAO {
    void guardar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Long idCliente);
    Cliente buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
}
