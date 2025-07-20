package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.ClienteDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.ClienteDAO;
import com.mycompany.ecolimpio.model.Cliente;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    public void registrar(Cliente cl) {

        clienteDAO.guardar(cl);
    }

    public void actualizar(Cliente cl) {

        clienteDAO.actualizar(cl);
    }

    public void eliminar(Long id) {

        clienteDAO.eliminar(id);
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }

    public Cliente listarPorId(Long id) {

        return clienteDAO.buscarPorId(id);
    }
}
