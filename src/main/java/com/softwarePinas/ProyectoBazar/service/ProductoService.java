package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Producto;
import com.softwarePinas.ProyectoBazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productRepository;

    @Override
    public Producto addProduct(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public List<Producto> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Producto> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Producto producto) {
        productRepository.save(producto);
    }
}
