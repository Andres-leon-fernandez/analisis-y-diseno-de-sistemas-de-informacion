/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecolimpio.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class Conexion {

    private static Conexion instancia;
    private Connection con;

    private final String url = "jdbc:mysql://localhost:3306/Ecolimpio";
    private final String user = "root";
    private final String paswword = "root";

    private Conexion() {
        try {
            con = DriverManager.getConnection(url, user, paswword);
            System.out.println("✅ Conexión establecida.");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al conectar a la base de datos: " + e.getMessage(), e);
        }
    }

    public static Conexion getinstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;

    }

    public Connection getconexion() {
        return con;
    }

}
