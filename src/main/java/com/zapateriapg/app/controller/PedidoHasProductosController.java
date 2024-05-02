package com.zapateriapg.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zapateriapg.app.entity.PedidoHasProductos;
import com.zapateriapg.app.service.PedidoHasProductosService;

@RestController
@RequestMapping("/api/pedidos_has_productos")
public class PedidoHasProductosController {

	 PedidoHasProductosService pedidoHasProductosService;

	    // Metodo para obtener un PedidoHasProductos por ID
	    @GetMapping("/{id}")
	    public PedidoHasProductos obtenerPedidoHasProductosById(@PathVariable Long id) {
	        return pedidoHasProductosService.obtenerPedidoHasProductosById(id);
	    }

	    // Metodo para crear un nuevo PedidoHasProductos
	    @PostMapping
	    public PedidoHasProductos insertarPedidoHasProductos(@RequestBody PedidoHasProductos pedidoHasProductos) {
	        return pedidoHasProductosService.insertarPedidoHasProductos(pedidoHasProductos);
	    }

	    // Metodo para obtener todos los PedidoHasProductos
	    @GetMapping
	    public List<PedidoHasProductos> obtenerTodosPedidosHasProductos() {
	        return pedidoHasProductosService.obtenerTodosPedidosHasProductos();
	    }

	    // Metodo para actualizar un PedidoHasProductos existente
	    @PutMapping("/{id}")
	    public PedidoHasProductos actualizarPedidoHasProductos(@RequestBody PedidoHasProductos pedidoHasProductos, @PathVariable Long id) {
	        return pedidoHasProductosService.actualizarPedidoHasProductos(pedidoHasProductos, id);
	    }

	    //Metodo para eliminar un PedidoHasProductos
	    @DeleteMapping("/{id}")
	    public void deletePedidoHasProductos(@PathVariable Long id) {
	    	pedidoHasProductosService.deletePedidoHasProductos(id);
	    }
}
