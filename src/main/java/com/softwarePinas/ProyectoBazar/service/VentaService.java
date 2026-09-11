package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Venta;
import com.softwarePinas.ProyectoBazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
