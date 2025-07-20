package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Factura;

import java.util.List;

public interface FacturaDAO {
    void guardar(Factura factura);
    void actualizar(Factura factura);
    void eliminar(Long idfactura);
    Factura buscarPorId(Long idfactura);
    List<Factura> listarTodos();
}
