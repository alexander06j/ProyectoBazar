package com.softwarePinas.ProyectoBazar.repository;

import com.softwarePinas.ProyectoBazar.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}
