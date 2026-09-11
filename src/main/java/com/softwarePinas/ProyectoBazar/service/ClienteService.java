package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Cliente;
import com.softwarePinas.ProyectoBazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAllClients() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findClientById(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void deleteClientById(long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void updateClient(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
