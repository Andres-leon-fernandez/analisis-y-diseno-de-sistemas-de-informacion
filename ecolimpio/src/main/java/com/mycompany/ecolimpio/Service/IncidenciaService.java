package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.HistorialClienteDAOImpl;
import com.mycompany.ecolimpio.dao.Impl.IncidenciaDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.HistorialClienteDAO;
import com.mycompany.ecolimpio.dao.Interfce.IncidenciaDAO;
import com.mycompany.ecolimpio.model.HistorialCliente;
import com.mycompany.ecolimpio.model.Incidencia;

import java.util.List;

public class IncidenciaService {
    private final IncidenciaDAO incidenciaDAO = new IncidenciaDAOImpl();

    public void registrar(Incidencia inc) {

        incidenciaDAO.guardar(inc);
    }

    public void actualizar(Incidencia inc) {

        incidenciaDAO.actualizar(inc);
    }

    public void eliminar(Long id) {
        incidenciaDAO.eliminar(id);
    }

    public List<Incidencia> listarTodos() {
        return incidenciaDAO.listarTodos();
    }

    public Incidencia listarPorId(Long id) {

        return incidenciaDAO.buscarPorId(id);
    }
}
