/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ecolimpio.dao.interfaces;

import com.mycompany.ecolimpio.model.Incidencia;
import java.sql.SQLException;
import java.util.List;

public interface IncidenciaDao {

    void crearIncidencia(Incidencia incidencia) throws SQLException;

    Incidencia obtenerIncidencia(int id) throws SQLException;

    List<Incidencia> listarIncidencias() throws SQLException;

    List<Incidencia> listarIncidenciasPorEstado(String estado) throws SQLException;

    List<Incidencia> listarIncidenciasPorCliente(int idCliente) throws SQLException;

    List<Incidencia> listarIncidenciasPorServicio(int idServicio) throws SQLException;

    void actualizarIncidencia(Incidencia incidencia) throws SQLException;

    void eliminarIncidencia(int id) throws SQLException;
}
