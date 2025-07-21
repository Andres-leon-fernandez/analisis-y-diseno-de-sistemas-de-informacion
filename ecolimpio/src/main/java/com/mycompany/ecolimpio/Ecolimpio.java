

package com.mycompany.ecolimpio;

import com.mycompany.ecolimpio.controller.ClienteController;
import com.mycompany.ecolimpio.model.Cliente;
import com.mycompany.ecolimpio.model.HistorialCliente;
import com.mycompany.ecolimpio.model.Servicio;
import com.mycompany.ecolimpio.vista.LoginFrame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andres
 */
public class Ecolimpio {

    public static void main(String[] args) {

        List<Servicio> sc = new ArrayList<>();
        Servicio sv = new Servicio();
        HistorialCliente hc = new HistorialCliente();
        ClienteController ctrCliente = new ClienteController();
        Cliente c1 = Cliente.builder()
                .nombreCompleto("jose perez")
                .dni("12345678")
                .email("andresagmail.com")
                .telefono("987654321")
                .direccion("av las palmeras ")
                .fechaRegistro(LocalDate.now())
                .build();

        ctrCliente.registrarCliente(c1);
        System.out.println(ctrCliente.listarClientes());

        LoginFrame lf1 = new LoginFrame();
        lf1.setLocationRelativeTo(null);
        lf1.setAlwaysOnTop(true);
        lf1.setVisible(true);
    }
}
