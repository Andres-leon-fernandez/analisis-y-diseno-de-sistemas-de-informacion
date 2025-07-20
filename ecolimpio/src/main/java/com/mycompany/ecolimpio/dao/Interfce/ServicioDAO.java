package com.mycompany.ecolimpio.dao.Interfce;

import com.mycompany.ecolimpio.model.Servicio;

import java.util.List;

public interface ServicioDAO {
    void guardar(Servicio servicio);

    void actualizar(Servicio servicio);

    void eliminar(Long idsercio);

    Servicio buscarPorId(Long idsercio);

    List<Servicio> listarTodos();
}
