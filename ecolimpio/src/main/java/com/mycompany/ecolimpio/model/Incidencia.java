package com.mycompany.ecolimpio.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tb_indidencia")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia", nullable = false, updatable = false)
    private Long idIncidencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio servicio;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;

    @Column(name = "tipo_incidencia", length = 50, nullable = false)
    private String tipoIncidencia;

    @Column(name = "fecha_hora_reporte", nullable = false, updatable = false)
    private LocalDateTime fechaHoraReporte;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "prioridad", length = 20, nullable = false)
    private String prioridad;

}
