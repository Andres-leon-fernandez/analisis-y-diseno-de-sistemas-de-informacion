package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Incidencia;

import java.util.List;

public interface IncidenciaDAO {
    void guardar(Incidencia incidencia);
    void actualizar(Incidencia incidencia);
    void eliminar(Long idincidencia);
    Incidencia buscarPorId(Long idincidencia);
    List<Incidencia> listarTodos();
}
