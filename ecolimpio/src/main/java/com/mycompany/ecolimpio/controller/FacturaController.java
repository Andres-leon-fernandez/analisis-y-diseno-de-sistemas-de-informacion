package com.mycompany.ecolimpio.controller;

import com.mycompany.ecolimpio.Service.ClienteService;
import com.mycompany.ecolimpio.Service.FacturaService;
import com.mycompany.ecolimpio.model.Cliente;
import com.mycompany.ecolimpio.model.Factura;

import java.util.List;

public class FacturaController {
    private final FacturaService facturaService = new FacturaService();

    public void registrarFactura(Factura fa) {
        facturaService.registrar(fa);
    }

    public void actualizarFactura(Factura fa) {
        facturaService.actualizar(fa);
    }

    public void eliminarFactura(Long id) {
        facturaService.eliminar(id);
    }

    public List<Factura> listarFactura() {
        return facturaService.listarTodos();
    }

    public Factura obtenerFactura(Long id) {
        return facturaService.listarPorId(id);
    }
}
