package com.zapateriaspg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zapateriaspg.app.entity.Producto;
import com.zapateriaspg.app.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    // Método para obtener un producto por su ID
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    // Método para un producto nuevo
    @PostMapping
    public Producto insertarProducto(@RequestBody Producto producto) {
        return productoService.insertarProducto(producto);
    }

    // Método para obtener todos los productos

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    // Método para actualizar un producto
    @PutMapping("/{id}")
    public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable Long id) {
        return productoService.actualizarProducto(producto, id);
    }

    // Método para eliminar un producto
    @DeleteMapping("/{id}")
    public void borrarProducto(@PathVariable Long id) {
        productoService.borrarProducto(id);
    }
}
