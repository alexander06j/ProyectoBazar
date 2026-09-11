package com.softwarePinas.ProyectoBazar.service;

import com.softwarePinas.ProyectoBazar.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {


    public Producto addProduct(Producto producto);

    public List<Producto> findAllProducts();

    public Optional<Producto> findProductById(Long id);

    public void deleteProductById(Long id);

    public void updateProduct(Producto producto);

    //CantidadMenor5
    public List<Producto> productosMenor5();

}
