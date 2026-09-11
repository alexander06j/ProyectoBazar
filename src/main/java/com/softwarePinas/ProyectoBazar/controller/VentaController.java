package com.softwarePinas.ProyectoBazar.controller;

import com.softwarePinas.ProyectoBazar.dto.VentaPorFechaDTO;
import com.softwarePinas.ProyectoBazar.model.Venta;
import com.softwarePinas.ProyectoBazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    //CREATE
    @PostMapping("/crear")
    public ResponseEntity<Venta> addVenta(@RequestBody Venta venta){
        ventaService.addVenta(venta);
        return ResponseEntity.ok(venta);
    }

    //READ-ALL
    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas(){
        List<Venta> ventas = ventaService.ventaList();
        return ResponseEntity.ok(ventas);
    }

    //READ-ONE
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id){
        Optional<Venta> venta = ventaService.findVentaById(id);
        return venta.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void deleteVentaById(@PathVariable Long id){
        ventaService.deleteVentaById(id);
    }

    //UPDATE
    @PutMapping("/editar")
    public void updateVenta(@RequestBody Venta venta){
        ventaService.updateVenta(venta);
    }

    @GetMapping("/productos/{codigo_venta}")
    public Optional<Venta> getProductosBySale(@PathVariable Long codigo_venta){
        Optional<Venta> ventas  = ventaService.findVentaById(codigo_venta);
        return ventas;
    }

    @GetMapping("/fecha/{fecha_venta}")
    public VentaPorFechaDTO findByFechaVenta(@PathVariable LocalDate fecha_venta){
        VentaPorFechaDTO venta = ventaService.ventasPorFecha(fecha_venta);
        return venta;
    }


}
