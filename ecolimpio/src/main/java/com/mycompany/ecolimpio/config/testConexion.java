package com.mycompany.ecolimpio.config;

import java.sql.Connection;

public class testConexion {
    public static void main(String[] args) {
        try {
            Conexion conexion = Conexion.getinstancia();
            Connection con = conexion.getconexion();

            if (con != null && !con.isClosed()) {
                System.out.println("✅ Conexión a la base de datos establecida correctamente.");
            } else {
                System.out.println("❌ La conexión está cerrada o es nula.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al probar la conexión: " + e.getMessage());
        }
    }
}
