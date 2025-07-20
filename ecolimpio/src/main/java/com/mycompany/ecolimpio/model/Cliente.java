package com.mycompany.ecolimpio.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cliente {

    private long idCliente;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDate fechaRegistro;

}

//Cliente cliente = Cliente.builder()
//    .nombreCompleto("Juan Pérez")
//    .email("juan@email.com")
//    .telefono("123456789")
//    .direccion("Calle Falsa 123")
//    .fechaRegistro(LocalDate.now())
//    .build();
