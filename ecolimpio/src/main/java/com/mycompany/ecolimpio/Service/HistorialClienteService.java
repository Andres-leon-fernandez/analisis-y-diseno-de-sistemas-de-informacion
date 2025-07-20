package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.FacturaDAOImpl;
import com.mycompany.ecolimpio.dao.Impl.HistorialClienteDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.FacturaDAO;
import com.mycompany.ecolimpio.dao.Interfce.HistorialClienteDAO;
import com.mycompany.ecolimpio.model.Factura;
import com.mycompany.ecolimpio.model.HistorialCliente;

import java.util.List;

public class HistorialClienteService {
    private final HistorialClienteDAO historialClienteDAO = new HistorialClienteDAOImpl();

    public void registrar(HistorialCliente hc) {

        historialClienteDAO.guardar(hc);
    }

    public void actualizar(HistorialCliente hc) {

        historialClienteDAO.actualizar(hc);
    }

    public void eliminar(Long id) {

        historialClienteDAO.eliminar(id);
    }

    public List<HistorialCliente> listarTodos() {
        return historialClienteDAO.listarTodos();
    }

    public HistorialCliente listarPorId(Long id) {

        return historialClienteDAO.buscarPorId(id);
    }
}
