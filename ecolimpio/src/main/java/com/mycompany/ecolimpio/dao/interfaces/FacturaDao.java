/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Factura;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andres
 */
public interface FacturaDao {

    void crearFactura(Factura factura) throws SQLException;

    Factura obtenerFactura(int id) throws SQLException;

    List<Factura> listarFacturas() throws SQLException;

    List<Factura> listarFacturasPorCliente(int idCliente) throws SQLException; // Nuevo método útil

    void actualizarFactura(Factura factura) throws SQLException;

    void eliminarFactura(int id) throws SQLException;
}
