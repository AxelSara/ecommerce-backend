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

import com.zapateriapg.app.entity.Pedido;
import com.zapateriapg.app.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	 PedidoService pedidoService;

	    // Metodo para obtener un pedido por ID
	    @GetMapping("/{id}")
	    public Pedido obtenerPedidoPorID(@PathVariable Long id) {
	        return pedidoService.obtenerPedidoPorID(id);
	    }

	    // Metodo para obtener un pedido por correo electronico
	    @GetMapping("/email/{email}")
	    public List<Pedido> obtenerPedidosDeUnUsuario(@PathVariable String email) {
	        return pedidoService.obtenerPedidosDeUnUsuario(email);
	    }

	    // Metodo para crear un nuevo pedido
	    @PostMapping
	    public Pedido insertarPedido(@RequestBody Pedido pedido) {
	        return pedidoService.insertarPedido(pedido);
	    }

	    // Metodo para obtener todos los pedido
	    @GetMapping
	    public List<Pedido> obtenerPedidos() {
	        return pedidoService.obtenerPedidos();
	    }

	    // Metodo para actualizar un pedido existente
	    @PutMapping("/{id}")
	    public Pedido actualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
	        return pedidoService.actualizarPedido(pedido, id);
	    }

	    // Metodo para eliminar un pedido
	    @DeleteMapping("/{id}")
	    public void eliminarPedido(@PathVariable Long id) {
	        pedidoService.eliminarPedido(id);
	    }
}
