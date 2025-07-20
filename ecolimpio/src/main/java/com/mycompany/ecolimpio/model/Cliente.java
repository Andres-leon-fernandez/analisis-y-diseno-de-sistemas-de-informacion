package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Parent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"servicios", "notificaciones", "hcliente"})
@Builder


@Entity
@Table(name = "tb_Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", insertable = false, updatable = false)
    private Long idCliente;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombreCompleto;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "email", length = 55, nullable = false)
    private String email;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "fecha_de_registro", updatable = false)
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Servicio> servicios;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private HistorialCliente hcliente;

    @OneToMany(mappedBy = "cliente")
    private List<Notificacion> notificaciones;

}