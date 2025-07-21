package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tb_Administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador", updatable = false, insertable = false)
    private Long idAdministrador;

    @Column(name = "User", nullable = false, length = 24)
    private String nombreUsuario;

    @Column(name = "email", nullable = false, length = 35)
    private String email;

    @Column(name = "password", nullable = false, length = 65)
    private String contrasena;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "administrador")
    private List<Notificacion> notificaciones;
}
