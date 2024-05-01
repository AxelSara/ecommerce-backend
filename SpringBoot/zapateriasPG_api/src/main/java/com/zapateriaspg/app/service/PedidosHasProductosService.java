package com.zapateriaspg.app.service;

import java.util.List;
import java.util.Optional;

import com.zapateriaspg.app.entity.PedidoHasProductos;

public interface PedidosHasProductosService {
    Optional<PedidoHasProductos> obtenerBolsaHasProductosById(Long id);
    List<PedidoHasProductos> obtenerTodosPedidosHasProductos(); 
    PedidoHasProductos insertarPedidoHasProductos(PedidoHasProductos pedidoHasProductos);
    PedidoHasProductos actualizarPedidoHasProductos(PedidoHasProductos pedidoHasProductos, Long id);
    void deletePedidoHasProductos(Long id);    
}


