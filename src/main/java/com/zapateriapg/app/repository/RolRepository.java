package com.zapateriapg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriapg.app.entity.Rol;

public interface RolRepository extends CrudRepository<Rol,Long> {
	Optional<Rol> findById(Long idRol);
}
