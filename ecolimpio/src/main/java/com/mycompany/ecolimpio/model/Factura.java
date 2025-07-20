package com.mycompany.ecolimpio.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "tb_facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura", updatable = false, insertable = false)
    private Long idFactura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Servicio> servicios;

    @Column(name = "fecha_hora_emision", updatable = false, nullable = false)
    private LocalDateTime fechaHoraEmision;

    @Column(name = "monto", precision = 3, scale = 2, nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "estado_pago", length = 10, nullable = false)
    private String estadoPago;
}
