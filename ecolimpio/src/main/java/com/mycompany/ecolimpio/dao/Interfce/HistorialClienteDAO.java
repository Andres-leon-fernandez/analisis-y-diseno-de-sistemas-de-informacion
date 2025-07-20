package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.HistorialCliente;

import java.util.List;

public interface HistorialClienteDAO {
    void guardar(HistorialCliente historialCliente);
    void actualizar(HistorialCliente historialCliente);
    void eliminar(Long idhistorialCliente);
    HistorialCliente buscarPorId(Long idhistorialCliente);
    List<HistorialCliente> listarTodos();
}
