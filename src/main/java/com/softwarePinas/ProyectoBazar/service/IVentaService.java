package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.dto.MayorVentaDTO;
import com.softwarePinas.ProyectoBazar.dto.VentaPorFechaDTO;
import com.softwarePinas.ProyectoBazar.model.Producto;
import com.softwarePinas.ProyectoBazar.model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVentaService {

    public Venta addVenta(Venta venta);

    public List<Venta> ventaList();

    public Optional<Venta> findVentaById(Long id);

    public void deleteVentaById(Long id);

    public void updateVenta(Venta venta);

    public List<Producto> findProductosBySale(Long codigo_venta);

    public VentaPorFechaDTO ventasPorFecha(LocalDate fecha_venta);

    public MayorVentaDTO ventaMayorMonto();
}
