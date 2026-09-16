package com.softwarePinas.ProyectoBazar.controller;

import com.softwarePinas.ProyectoBazar.dto.MayorVentaDTO;
import com.softwarePinas.ProyectoBazar.dto.VentaDTO;
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
    public ResponseEntity<List<VentaDTO>> getAllVentas(){
        List<VentaDTO> ventas = ventaService.ventaListDTO();
        return ResponseEntity.ok(ventas);
    }

    //READ-ONE
    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> getVentaById(@PathVariable Long id){
        Optional<VentaDTO> venta = ventaService.findVentaDTOById(id);
        return venta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public void deleteVentaById(@PathVariable Long id){
        ventaService.deleteVentaById(id);
    }

    //UPDATE
    @PutMapping("/editar/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta){
        Optional<Venta> ventaExistente = ventaService.findVentaById(id);

        if(ventaExistente.isPresent()){
            Venta actualizada = ventaExistente.get();
            actualizada.setFechaVenta(venta.getFechaVenta());
            actualizada.setCliente(venta.getCliente());
            actualizada.setListaDetalles(venta.getListaDetalles());

            ventaService.updateVenta(actualizada);
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @GetMapping("/mayor_venta")
    public MayorVentaDTO ventaMayorMonto(){
        return ventaService.ventaMayorMonto();
    }

}
