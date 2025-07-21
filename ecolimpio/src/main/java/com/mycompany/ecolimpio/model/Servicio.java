/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecolimpio.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tb_servicios")
public class Servicio {

    public enum EstadoServicio {
        PROGRAMADO,
        EN_PROCESO,
        FINALIZADO,
        CANCELADO
    }

    public enum TipoServicio {
        LIMPIEZA_GENERAL,
        DESINFECCION,
        MANTENIMIENTO,
        OTRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio", nullable = false, updatable = false)
    private Long idServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servicio", nullable = false, length = 100)
    private TipoServicio tipo;

    @Column(name = "fecha_solicitud_fecha", nullable = false, updatable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_programada", nullable = false, updatable = false)
    private LocalDateTime fechaProgramada;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoServicio estado;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Incidencia> incidencias;

    @Column(name = "subtotal", precision = 3, scale = 2, nullable = false)
    private BigDecimal subTotal;

    @Lob
    @Column(name = "descripcion", nullable = false, updatable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_historial")
    private HistorialCliente historialcliente;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
}
