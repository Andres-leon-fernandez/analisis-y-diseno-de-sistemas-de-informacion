package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.AdministradorDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.AdministradorDAO;
import com.mycompany.ecolimpio.model.Administrador;

import java.util.List;

public class AdministradorService {
    private final AdministradorDAO administradorDAO = new AdministradorDAOImpl();

    public void registrar(Administrador admin) {

        administradorDAO.guardar(admin);
    }

    public void actualizar(Administrador admin) {

        administradorDAO.actualizar(admin);
    }

    public void eliminar(Long id) {

        administradorDAO.eliminar(id);
    }

    public List<Administrador> listarTodos() {
        return administradorDAO.listarTodos();
    }

    public Administrador listarPorId(Long id) {

        return administradorDAO.buscarPorId(id);
    }
}
