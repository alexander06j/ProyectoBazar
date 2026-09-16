package com.softwarePinas.ProyectoBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DetalleVentaDTO {

    private String nombreProducto;
    private String marcaProducto;
    private Integer cantidad;
    private BigDecimal subtotal;

}
