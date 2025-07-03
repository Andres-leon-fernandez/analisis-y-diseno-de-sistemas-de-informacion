package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Servicio;
import java.sql.SQLException;
import java.util.List;

public interface ServicioDao {

    void crearServicio(Servicio servicio) throws SQLException;

    Servicio obtenerServicio(int id) throws SQLException;

    List<Servicio> listarServicios() throws SQLException;

    void actualizarServicio(Servicio servicio) throws SQLException;

    void eliminarServicio(int id) throws SQLException;
}
