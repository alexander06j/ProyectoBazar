package com.softwarePinas.ProyectoBazar.repository;

import com.softwarePinas.ProyectoBazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
