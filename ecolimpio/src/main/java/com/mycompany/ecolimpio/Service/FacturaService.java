package com.mycompany.ecolimpio.Service;

import com.mycompany.ecolimpio.dao.Impl.ClienteDAOImpl;
import com.mycompany.ecolimpio.dao.Impl.FacturaDAOImpl;
import com.mycompany.ecolimpio.dao.Interfce.ClienteDAO;
import com.mycompany.ecolimpio.dao.Interfce.FacturaDAO;
import com.mycompany.ecolimpio.model.Cliente;
import com.mycompany.ecolimpio.model.Factura;

import java.util.List;

public class FacturaService {

    private final FacturaDAO facturaDAO = new FacturaDAOImpl();

    public void registrar(Factura fa) {

        facturaDAO.guardar(fa);
    }

    public void actualizar(Factura fa) {

        facturaDAO.actualizar(fa);
    }

    public void eliminar(Long id) {

        facturaDAO.eliminar(id);
    }

    public List<Factura> listarTodos() {
        return facturaDAO.listarTodos();
    }

    public Factura listarPorId(Long id) {

        return facturaDAO.buscarPorId(id);
    }
}
