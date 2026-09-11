package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.dto.VentaPorFechaDTO;
import com.softwarePinas.ProyectoBazar.model.DetalleVenta;
import com.softwarePinas.ProyectoBazar.model.Producto;
import com.softwarePinas.ProyectoBazar.model.Venta;
import com.softwarePinas.ProyectoBazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public Venta addVenta(Venta venta) {
        return ventaRepo.save(venta);
    }

    @Override
    public List<Venta> ventaList() {
        return ventaRepo.findAll();
    }

    @Override
    public Optional<Venta> findVentaById(Long id) {
        return ventaRepo.findById(id);
    }

    @Override
    public void deleteVentaById(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void updateVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Producto> findProductosBySale(Long codigo_venta) {
        Venta venta = ventaRepo.findById(codigo_venta).orElseThrow(null);
        return venta.getListaDetalles()
                .stream()
                .map(DetalleVenta::getProducto)
                .toList();
    }

    @Override
    public VentaPorFechaDTO ventasPorFecha(LocalDate fecha_venta) {
        List<Venta> ventas = ventaRepo.findByFechaVenta(fecha_venta);
        Long cantidadVentas = (long) ventas.size();
        BigDecimal montoTotal = ventas.stream()
                .map(Venta::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new VentaPorFechaDTO(
                fecha_venta,
                cantidadVentas,
                montoTotal
        );
    }

}
