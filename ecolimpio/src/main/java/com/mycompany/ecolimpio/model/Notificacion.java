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
@Table(name = "tb_notificacion")
public class Notificacion {

    public enum TipoNotificacion {
        CLIENTE,
        TECNICO,
        ADMINISTRADOR
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion", nullable = false, updatable = false)
    private Long idNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    @Lob
    @Column(name = "mensaje", nullable = false, updatable = false)
    private String mensaje;

    @Column(name = "fecha_hora_notificacion", nullable = false, updatable = false)
    private LocalDateTime fechaHoraNotificacion;

    @Column(name = "leida", nullable = false)
    private boolean leida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_notificacion", nullable = false)
    private TipoNotificacion tipoNotificacion;
}
