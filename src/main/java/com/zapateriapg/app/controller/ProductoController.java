package com.zapateriapg.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.zapateriapg.app.entity.Producto;
import com.zapateriapg.app.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	 ProductoService productoService;

	    // Metodo para obtener un producto por ID
	    @GetMapping("/{id}")
	    public Producto gobtenerProductoPorId(@PathVariable Long id) {
	        return productoService.obtenerProductoPorId(id);
	    }

	    // Metodo para crear un nuevo producto
	    @PostMapping
	    public Producto insertarProducto(@RequestBody Producto producto) {
	        return productoService.insertarProducto(producto);
	    }

	    // Metodo para obtener todos los productos
	    @GetMapping
	    public List<Producto> obtenerTodosLosProductos() {
	        return productoService.obtenerTodosLosProductos();
	    }

	    // Metodo para actualizar un produto existente
	    @PutMapping("/{id}")
	    public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable Long id) {
	        return productoService.actualizarProducto(producto, id);
	    }

	    //Metodo para eliminar un producto
	    @DeleteMapping("/{id}")
	    public void borrarProducto(@PathVariable Long id) {
	        productoService.borrarProducto(id);
	    }
}
