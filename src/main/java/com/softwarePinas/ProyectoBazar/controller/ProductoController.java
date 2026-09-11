package com.softwarePinas.ProyectoBazar.controller;

import com.softwarePinas.ProyectoBazar.model.Producto;
import com.softwarePinas.ProyectoBazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    //Create
    @PostMapping("/crear")
    public ResponseEntity<Producto> createProduct(@RequestBody Producto producto){
        productoService.addProduct(producto);
        return ResponseEntity.ok(producto);
    }
    //READ-all
    @GetMapping
    public ResponseEntity <List<Producto>> getAllProducts(){
        List<Producto> productos = productoService.findAllProducts();
        return ResponseEntity.ok(productos);
    }
    //Read-one
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Optional<Producto> producto = productoService.findProductById(id);
        return producto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    //Delete
    @DeleteMapping("/eliminar/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoService.deleteProductById(id);
    }
    //Update
    @PutMapping("/editar")
    public void updateProducto(@RequestBody Producto producto){
        productoService.updateProduct(producto);
    }
}
