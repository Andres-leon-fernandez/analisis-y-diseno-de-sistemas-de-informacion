package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.AdministradorDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.AdministradorDAO;
import com.mycompany.ecolimpio.model.Administrador;
import com.mycompany.ecolimpio.util.Sha256;

import java.util.List;
import javax.swing.JOptionPane;
import lombok.Builder;

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

    public Administrador LoginServicio(String user, String paswword) {
        List<Administrador> administradores = administradorDAO.listarTodos();
        String paswwordHash = Sha256.sha256(paswword);
        for (Administrador admin : administradores) {
            if (admin.getNombreUsuario().equals(user) && admin.getContrasena().equals(paswwordHash)) {
                return admin;
                
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario o Contraseña erronia");
        return null;
    }
}
