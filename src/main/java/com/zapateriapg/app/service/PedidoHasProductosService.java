package com.zapateriapg.app.service;

import java.util.List;

import com.zapateriapg.app.entity.PedidoHasProductos;

public interface PedidoHasProductosService {
    PedidoHasProductos obtenerPedidoHasProductosById(Long id);
    List<PedidoHasProductos> obtenerTodosPedidosHasProductos(); 
    PedidoHasProductos insertarPedidoHasProductos(PedidoHasProductos pedidoHasProductos);
    PedidoHasProductos actualizarPedidoHasProductos(PedidoHasProductos pedidoHasProductos, Long id);
    void deletePedidoHasProductos(Long id);    
}