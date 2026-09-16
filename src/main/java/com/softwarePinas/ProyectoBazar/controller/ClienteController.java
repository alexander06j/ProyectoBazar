package com.softwarePinas.ProyectoBazar.controller;

import com.softwarePinas.ProyectoBazar.model.Cliente;
import com.softwarePinas.ProyectoBazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    //Create
    @PostMapping("/crear")
    public ResponseEntity<Cliente> createProduct(@RequestBody Cliente cliente){
        clienteService.addCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    //READ-ALL
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClients(){
        List<Cliente> clientes = clienteService.findAllClients();
        return ResponseEntity.ok(clientes);
    }

    //READ-ONE
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findClientById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteClientById(id);
    }

    //UPDATE
    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteExistente = clienteService.findClientById(id);

        if(clienteExistente.isPresent()){
            Cliente actualizado = clienteExistente.get();
            actualizado.setNombre(cliente.getNombre());
            actualizado.setApellido(cliente.getApellido());
            actualizado.setDni(cliente.getDni());

            clienteService.updateClient(actualizado);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
