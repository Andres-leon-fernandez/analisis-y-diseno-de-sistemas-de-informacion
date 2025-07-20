package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.ServicioDAOImpl;
import com.mycompany.ecolimpio.dao.Impl.TecnicoDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.ServicioDAO;
import com.mycompany.ecolimpio.dao.Interfce.TecnicoDAO;
import com.mycompany.ecolimpio.model.Servicio;
import com.mycompany.ecolimpio.model.Tecnico;

import java.util.List;

public class TecnicoService {
    private final TecnicoDAO tecnicoDAO = new TecnicoDAOImpl();

    public void registrar(Tecnico tec) {

        tecnicoDAO.guardar(tec);
    }

    public void actualizar(Tecnico tec) {

        tecnicoDAO.actualizar(tec);
    }

    public void eliminar(Long id) {
        tecnicoDAO.eliminar(id);
    }

    public List<Tecnico> listarTodos() {
        return tecnicoDAO.listarTodos();
    }

    public Tecnico listarPorId(Long id) {

        return tecnicoDAO.buscarPorId(id);
    }
}
