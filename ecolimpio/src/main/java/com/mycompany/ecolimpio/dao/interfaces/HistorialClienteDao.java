/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.HistorialCliente;
import java.sql.SQLException;
import java.util.List;

public interface HistorialClienteDao {
    void crearHistorialCliente(HistorialCliente historial) throws SQLException;
    HistorialCliente obtenerHistorialCliente(int id) throws SQLException;
    List<HistorialCliente> listarHistorialesCliente() throws SQLException;
    List<HistorialCliente> listarHistorialPorCliente(int idCliente) throws SQLException; // Muy útil para ver el historial de un cliente específico
    void actualizarHistorialCliente(HistorialCliente historial) throws SQLException;
    void eliminarHistorialCliente(int id) throws SQLException;
}