package com.mycompany.ecolimpio;

import com.mycompany.ecolimpio.controller.AdministradorController;
import com.mycompany.ecolimpio.controller.ClienteController;
import com.mycompany.ecolimpio.model.Administrador;
import com.mycompany.ecolimpio.model.Cliente;
import com.mycompany.ecolimpio.model.Factura;
import com.mycompany.ecolimpio.model.HistorialCliente;
import com.mycompany.ecolimpio.model.Incidencia;
import com.mycompany.ecolimpio.model.Notificacion;
import com.mycompany.ecolimpio.model.Servicio;
import com.mycompany.ecolimpio.model.Tecnico;
import com.mycompany.ecolimpio.util.Sha256;
import com.mycompany.ecolimpio.vista.LoginFrame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andres
 */
public class Ecolimpio {
    
    public static void main(String[] args) {

//        List<Servicio> sc = new ArrayList<>();
//        Servicio sv = new Servicio();
//        HistorialCliente hc = new HistorialCliente();
//        ClienteController ctrCliente = new ClienteController();
//        Cliente c1 = Cliente.builder()
//                .nombreCompleto("jose perez")
//                .dni("12345678")
//                .email("andresagmail.com")
//                .telefono("987654321")
//                .direccion("av las palmeras ")
//                .fechaRegistro(LocalDate.now())
//                .build();
//
//        ctrCliente.registrarCliente(c1);
//        System.out.println(ctrCliente.listarClientes());
//
//        Administrador administrador = Administrador.builder()
//                .nombreUsuario("root")
//                .contrasena(Sha256.sha256("root"))
//                .build();
//        AdministradorController ctrlAdmin = new AdministradorController();
//        ctrlAdmin.registrarAdministrador(administrador);
        LoginFrame lf1 = new LoginFrame();
        lf1.setLocationRelativeTo(null);
        lf1.setAlwaysOnTop(true);
        lf1.setVisible(true);
//        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecolimpioPU");
//        EntityManager em = emf.createEntityManager();
//        
//        try {
//            em.getTransaction().begin();
//            Administrador admin = Administrador.builder()
//                    .nombreUsuario("root")
//                    .email("admin@ecolimpio.com")
//                    .contrasena(Sha256.sha256("root"))
//                    .fechaCreacion(LocalDate.now())
//                    .build();
//            em.persist(admin);
////            Tecnico tecnico = Tecnico.builder()
////                    .nombre("Luis")
////                    .apellido("Torres")
////                    .dni("87654321")
////                    .especialidad(Tecnico.EspecialidadTecnico.DESINFECCION)
////                    .telefono("912345678")
////                    .email("luis.torres@ecolimpio.com")
////                    .fechaContratacion(LocalDate.now())
////                    .activo(true)
////                    .build();
////            em.persist(tecnico);
////            Cliente cliente = Cliente.builder()
////                    .nombreCompleto("Juan Pérez")
////                    .dni("12345678")
////                    .email("juan.perez@gmail.com")
////                    .telefono("987654321")
////                    .direccion("Av. Siempre Viva 123")
////                    .fechaRegistro(LocalDate.now())
////                    .build();
////            em.persist(cliente);
////            HistorialCliente historial = HistorialCliente.builder()
////                    .cliente(cliente)
////                    .fechaHoraRegistro(LocalDateTime.now())
////                    .descripcion("Cliente nuevo, historial creado automáticamente.")
////                    .build();
////            em.persist(historial);
////            Factura factura = Factura.builder()
////                    .cliente(cliente)
////                    .fechaHoraEmision(LocalDateTime.now())
////                    .estadoPago("PENDIENTE")
////                    .montoTotal(new BigDecimal("120.00"))
////                    .build();
////            em.persist(factura);
////            Servicio servicio = Servicio.builder()
////                    .cliente(cliente)
////                    .tecnico(tecnico)
////                    .tipo(Servicio.TipoServicio.LIMPIEZA_GENERAL)
////                    .fechaSolicitud(LocalDateTime.now())
////                    .fechaProgramada(LocalDateTime.now().plusDays(1))
////                    .estado(Servicio.EstadoServicio.PROGRAMADO)
////                    .subTotal(new BigDecimal("120.00"))
////                    .descripcion("Limpieza general de oficina")
////                    .historialcliente(historial)
////                    .factura(factura)
////                    .build();
////            em.persist(servicio);
////            Incidencia incidencia = Incidencia.builder()
////                    .servicio(servicio)
////                    .cliente(cliente)
////                    .tecnico(tecnico)
////                    .titulo("Producto no entregado")
////                    .descripcion("El cliente indica que un producto fue omitido.")
////                    .tipoIncidencia("Queja")
////                    .fechaHoraReporte(LocalDateTime.now())
////                    .estado("Abierta")
////                    .prioridad("Alta")
////                    .build();
////            em.persist(incidencia);
////            Notificacion notificacion = Notificacion.builder()
////                    .cliente(cliente)
////                    .administrador(admin)
////                    .mensaje("Su servicio ha sido programado.")
////                    .fechaHoraNotificacion(LocalDateTime.now())
////                    .leida(false)
////                    .tipoNotificacion(Notificacion.TipoNotificacion.CLIENTE)
////                    .build();
////            em.persist(notificacion);
////            cliente.setServicios(List.of(servicio));
////            cliente.setHcliente(historial);
////            cliente.setNotificaciones(List.of(notificacion));
////            historial.setServicio(List.of(servicio));
////            factura.setServicios(List.of(servicio));
//            
//            em.getTransaction().commit();
//            System.out.println("✅ Inserción completada con éxito.");
//            
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
    }
}
