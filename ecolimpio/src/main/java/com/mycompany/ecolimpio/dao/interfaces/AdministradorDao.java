package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Administrador;
import java.sql.SQLException;
import java.util.List;

public interface AdministradorDao {

    void crearAdministrador(Administrador administrador) throws SQLException;

    Administrador obtenerAdministrador(int id) throws SQLException;

    Administrador obtenerAdministradorPorEmail(String email) throws SQLException;

    List<Administrador> listarAdministradores() throws SQLException;

    void actualizarAdministrador(Administrador administrador) throws SQLException;

    void eliminarAdministrador(int id) throws SQLException;
}
