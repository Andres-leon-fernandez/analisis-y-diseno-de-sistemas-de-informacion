package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tb_tecnico")
public class Tecnico {
    
    
    public enum Activo{
        ACTIVO,
        DESACTIVO
    }

    public enum EspecialidadTecnico{
        LIMPIEZA_GENERAL,
        DESINFECCION,
        FUMIGACION,
        LIMPIEZA_POST_OBRA,
        LIMPIEZA_INDUSTRIAL,
        LIMPIEZA_VENTANAS_ALTURA,
        MANTENIMIENTO_PISOS,
        TRATAMIENTO_AMBIENTAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico",updatable = false,nullable = false)
    private Long idTecnico;

    @Column(name = "nombre",nullable = false,updatable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false,updatable = false)
    private String apellido;

    @Column(name = "dni",nullable = false,updatable = false)
    private String dni;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad",nullable = false,length = 50)
    private EspecialidadTecnico especialidad;

    @Column(name = "telefono",nullable = false,length = 50)
    private String telefono;

    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @Column(name = "fecha_contratacion",nullable = false,updatable = false)
    private LocalDate fechaContratacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "activo",nullable = false)
    private Activo activo;

    @OneToMany(mappedBy = "tecnico")
    private List<Notificacion> notificaciones;
}
