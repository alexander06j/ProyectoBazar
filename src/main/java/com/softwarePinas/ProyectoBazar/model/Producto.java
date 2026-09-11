package com.softwarePinas.ProyectoBazar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private BigDecimal costo;
    private Integer cantidad_disponible;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> listaDetalles;

}
