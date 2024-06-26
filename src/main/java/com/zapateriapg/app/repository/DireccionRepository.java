package com.zapateriapg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriapg.app.entity.Direccion;


public interface DireccionRepository extends CrudRepository<Direccion , Long> {
	Optional<Direccion> findById(Long idDireccion);
	Optional<Direccion> findByEmail(String email);
	Iterable<Direccion> findAll();
}
