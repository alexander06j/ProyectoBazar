package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.dto.DetalleVentaDTO;
import com.softwarePinas.ProyectoBazar.dto.MayorVentaDTO;
import com.softwarePinas.ProyectoBazar.dto.VentaDTO;
import com.softwarePinas.ProyectoBazar.dto.VentaPorFechaDTO;
import com.softwarePinas.ProyectoBazar.model.DetalleVenta;
import com.softwarePinas.ProyectoBazar.model.Producto;
import com.softwarePinas.ProyectoBazar.model.Venta;
import com.softwarePinas.ProyectoBazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Venta venta = ventaRepo.findById(codigo_venta).orElseThrow(() -> new RuntimeException("Venta no encontrada. "));
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

    @Override
    public MayorVentaDTO ventaMayorMonto() {
        Venta venta = ventaRepo.findTopByOrderByTotalDesc()
                .orElseThrow(()-> new RuntimeException("No existen ventas"));

        int cantidadProductos = venta.getListaDetalles().stream()
                .mapToInt(DetalleVenta::getCantidad)
                .sum();

        return new MayorVentaDTO(
                venta.getCodigo_venta(),
                venta.getTotal(),
                cantidadProductos,
                venta.getCliente().getNombre(),
                venta.getCliente().getApellido()
        );

    }

    @Override
    public List<VentaDTO> ventaListDTO() {
        return ventaRepo.findAll().stream()
                .map(v -> new VentaDTO(
                        v.getCodigo_venta(),
                        v.getFechaVenta(),
                        v.getTotal(),
                        v.getCliente().getNombre(),
                        v.getCliente().getApellido()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VentaDTO> findVentaDTOById(Long id) {
        return ventaRepo.findById(id)
                .map(v -> new VentaDTO(
                        v.getCodigo_venta(),
                        v.getFechaVenta(),
                        v.getTotal(),
                        v.getCliente().getNombre(),
                        v.getCliente().getApellido()
                ));
    }

    @Override
    public List<DetalleVentaDTO> getProductosDeVenta(Long codigoVenta) {
        Optional<Venta> ventaOpt = ventaRepo.findById(codigoVenta);

        if (ventaOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            return venta.getListaDetalles().stream()
                    .map(detalle -> new DetalleVentaDTO(
                            detalle.getProducto().getNombre(),
                            detalle.getProducto().getMarca(),
                            detalle.getCantidad(),
                            detalle.getSubtotal()
                    ))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
