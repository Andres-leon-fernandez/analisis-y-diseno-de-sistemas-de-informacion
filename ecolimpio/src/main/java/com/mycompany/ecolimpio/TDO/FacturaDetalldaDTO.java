
package com.mycompany.ecolimpio.TDO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturaDetalldaDTO {
    private Long idFactura;
    private String nombreCliente;
    private String direccionCliente;
    private String tipoServicio;
    private String nombreTecnico;
    private BigDecimal montoTotal;
    private LocalDateTime fechaEmision;
}
