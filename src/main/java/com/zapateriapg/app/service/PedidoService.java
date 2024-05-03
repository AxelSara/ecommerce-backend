package com.zapateriapg.app.service;

import java.util.List;
import com.zapateriapg.app.entity.Pedido;

public interface PedidoService {

    Pedido obtenerPedidoPorID(long id);
    List<Pedido> obtenerPedidos();
    List<Pedido> obtenerPedidosDeUnUsuario(String email);
    Pedido insertarPedido(Pedido pedido);
    Pedido actualizarPedido(Pedido pedido, long id);
    void eliminarPedido(long id); 
    
}
