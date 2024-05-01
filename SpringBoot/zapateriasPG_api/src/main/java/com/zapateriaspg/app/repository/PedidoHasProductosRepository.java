package com.zapateriaspg.app.repository;

// import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriaspg.app.entity.PedidoHasProductos;

public interface PedidoHasProductosRepository extends CrudRepository<PedidoHasProductos, Long> {

    // Optional<PedidoHasProductos> findByPedido(Long id);
    // Optional<PedidoHasProductos> findByProducto(Long id); 
} 
