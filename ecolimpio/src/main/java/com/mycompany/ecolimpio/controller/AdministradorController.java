package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.AdministradorService;
import com.mycompany.ecolimpio.model.Administrador;

import java.util.List;

public class AdministradorController {

    private final AdministradorService administradorService = new AdministradorService();

    public void registrarAdministrador(Administrador admin) {
        administradorService.registrar(admin);
    }

    public void actualizarAdministrador(Administrador admin) {
        administradorService.actualizar(admin);
    }

    public void eliminarAdministrador(Long id) {
        administradorService.eliminar(id);
    }

    public List<Administrador> listarAdministradores() {
        return administradorService.listarTodos();
    }

    public Administrador obtenerAdministrador(Long id) {
        return administradorService.listarPorId(id);
    }
}
