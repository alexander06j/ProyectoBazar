package com.softwarePinas.ProyectoBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MayorVentaDTO {

    private Long codigo_venta;
    private BigDecimal total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

}
