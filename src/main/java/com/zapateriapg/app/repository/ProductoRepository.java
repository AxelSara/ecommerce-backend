package com.zapateriapg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriapg.app.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
	Optional<Producto>findById(Long idProducto);
	// obtener todos los productos
	Iterable<Producto> findAll();

}
