package com.softwarePinas.ProyectoBazar.repository;

import com.softwarePinas.ProyectoBazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
