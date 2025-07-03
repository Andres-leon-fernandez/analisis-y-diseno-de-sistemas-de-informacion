
package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Tecnico;
import java.sql.SQLException;
import java.util.List;

public interface TecnicoDao {

    void crearTecnico(Tecnico tecnico) throws SQLException;

    Tecnico obtenerTecnico(int id) throws SQLException;

    List<Tecnico> listarTecnicos() throws SQLException;

    List<Tecnico> listarTecnicosPorEspecialidad(String especialidad) throws SQLException;

    void actualizarTecnico(Tecnico tecnico) throws SQLException;

    void eliminarTecnico(int id) throws SQLException;
}
