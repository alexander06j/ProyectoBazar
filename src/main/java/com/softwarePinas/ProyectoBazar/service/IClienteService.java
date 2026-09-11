package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    public Cliente addCliente(Cliente cliente);

    public List<Cliente> findAllClients();

    public Optional<Cliente> findClientById(long id);

    public void deleteClientById(long id);

    public void updateClient(Cliente cliente);


}
