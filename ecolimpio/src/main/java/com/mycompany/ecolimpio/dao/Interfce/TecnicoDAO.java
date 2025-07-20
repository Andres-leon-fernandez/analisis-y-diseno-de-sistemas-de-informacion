package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Tecnico;

import java.util.List;

public interface TecnicoDAO {
    void guardar(Tecnico tecnico);

    void actualizar(Tecnico tecnico);

    void eliminar(Long idtecnico);

    Tecnico buscarPorId(Long idtecnico);

    List<Tecnico> listarTodos();
}
