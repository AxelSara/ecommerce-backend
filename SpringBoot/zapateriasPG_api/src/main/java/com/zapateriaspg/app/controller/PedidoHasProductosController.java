package com.zapateriaspg.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zapateriaspg.app.entity.PedidoHasProductos;
import com.zapateriaspg.app.service.PedidosHasProductosService;

@RestController
@RequestMapping("/api/pedidohasproductos")
public class PedidoHasProductosController {
    
    @Autowired
    private PedidosHasProductosService pedidosHasProductosService;

    // Método para obtener los PedidosHasProductos
    @GetMapping("/{id}")
    public Optional<PedidoHasProductos> getBolsaHasProductosById(@PathVariable Long id) {
        return pedidosHasProductosService.getBolsaHasProductosById(id);
    }

    // Método para obtener todos los PedidosHasProductos
    @GetMapping
    public List<PedidoHasProductos> getAllBolsaHasProductos() {
        return pedidosHasProductosService.getAllBolsaHasProductos();
    }

    // Método para borrar un PedidoHasProducto
    @DeleteMapping
    public void deleteBolsaHasProductos(@PathVariable Long id) {
        pedidosHasProductosService.deleteBolsaHasProductos(id);
    }
}
