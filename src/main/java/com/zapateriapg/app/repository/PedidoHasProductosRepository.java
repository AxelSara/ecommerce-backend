package com.zapateriapg.app.repository;
import java.util.Optional;

// import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.zapateriapg.app.entity.PedidoHasProductos;

public interface PedidoHasProductosRepository extends CrudRepository<PedidoHasProductos, Long> {

    Optional<PedidoHasProductos> findByPedidoIdPedido(Long id);
    Optional<PedidoHasProductos> findByProductoIdProducto(Long id); 
} 
