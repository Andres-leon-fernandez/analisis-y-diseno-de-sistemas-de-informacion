package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Administrador;
import com.mycompany.ecolimpio.model.Cliente;

import java.util.List;

public interface AdministradorDAO {
    void guardar(Administrador administrador);
    void actualizar(Administrador administrador);
    void eliminar(Long idadministrador);
    Administrador buscarPorId(Long idadministrador);
    List<Administrador> listarTodos();
}
