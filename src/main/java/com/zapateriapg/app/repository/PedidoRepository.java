package com.zapateriapg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriapg.app.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido , Long> {
	Optional<Pedido> findById(Long idPedido);
	Iterable<Pedido> findByEmail(String email);
	Iterable<Pedido> findAll();
	boolean existsByEmail(String email);


}
