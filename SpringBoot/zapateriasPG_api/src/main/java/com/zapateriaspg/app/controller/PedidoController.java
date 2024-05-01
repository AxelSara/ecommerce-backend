package com.zapateriaspg.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zapateriaspg.app.entity.Pedido;
import com.zapateriaspg.app.service.PedidoService;
import com.zapateriaspg.app.entity.Usuario;
import com.zapateriaspg.app.service.UsuarioService;


@RestController
@RequestMapping("/api/Pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    private UsuarioService usuarioService;

    // Método para obtener un pedido por ID
    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorID(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorID(id);
    }

    // Método para obtener los pedidos de un usuario
    @GetMapping("/{email}")
    public List<Pedido> obtenerPedidosDeUnUsuario(@PathVariable String email) {
        Usuario user = usuarioService.getUsuarioByEmail(email);
        if(user == null){
            System.out.println("Not found");
            return null; // Cambiar el return
        }
        return pedidoService.obtenerPedidosDeUnUsuario(email);
    }

    // Método para obtener todos los pedidos
    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }

    // Método para crear pedidos
    @GetMapping
    public Pedido insertarPedido(@PathVariable Pedido pedido) {
        return pedidoService.insertarPedido(pedido);
    }

    // Método para actualizar un pedido
    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable Pedido pedido, Long id) {
        return pedidoService.actualizarPedido(pedido, id);
    }

    // Método para eliminar un pedido
    @DeleteMapping("/{id}")
    public void eliminarPedido(@RequestParam Long id) {
        pedidoService.eliminarPedido(id);
    }
    
}
