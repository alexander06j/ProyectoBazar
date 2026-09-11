package com.softwarePinas.ProyectoBazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VentaPorFechaDTO {

    private LocalDate fecha;
    private Long cantidadVentas;
    private BigDecimal montoTotal;

}
