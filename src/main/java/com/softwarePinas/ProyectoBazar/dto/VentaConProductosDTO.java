package com.softwarePinas.ProyectoBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VentaConProductosDTO {

    private Long codigo_venta;
    private LocalDate fechaVenta;
    private BigDecimal total;
    private String nombreCliente;
    private String apellidoCliente;
    private List<DetalleVentaDTO> productos;

}
