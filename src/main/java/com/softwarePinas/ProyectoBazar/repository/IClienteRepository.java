package com.softwarePinas.ProyectoBazar.repository;

import com.softwarePinas.ProyectoBazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
