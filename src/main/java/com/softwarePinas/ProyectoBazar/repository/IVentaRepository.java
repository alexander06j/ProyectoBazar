package com.softwarePinas.ProyectoBazar.repository;

import com.softwarePinas.ProyectoBazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findByFechaVenta(LocalDate fecha_venta);

}
