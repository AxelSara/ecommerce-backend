package com.zapateriaspg.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PedidoHasProductosRepository extends CrudRepository<PedidoHasProductosRepository, Long> {

    Optional<PedidoHasProductosRepository> findByPedido(Long id);
    Optional<PedidoHasProductosRepository> findByProducto(Long id); 
} 
