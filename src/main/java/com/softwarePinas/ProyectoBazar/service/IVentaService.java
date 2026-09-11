package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaService {

    public Venta addVenta(Venta venta);

    public List<Venta> ventaList();

    public Optional<Venta> findVentaById(Long id);

    public void deleteVentaById(Long id);

    public void updateVenta(Venta venta);

}
