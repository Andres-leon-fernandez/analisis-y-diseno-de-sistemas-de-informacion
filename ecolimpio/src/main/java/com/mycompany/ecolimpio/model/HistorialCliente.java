package com.mycompany.ecolimpio.model;

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
@Table(name = "tb_historial_clientes")
public class HistorialCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial", updatable = false, insertable = false)
    private Long idHistorial;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;


    @OneToMany(mappedBy = "historialcliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicio;

    @Column(name = "fecha_hora_registro", updatable = false, nullable = false)
    private LocalDateTime fechaHoraRegistro;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

}
