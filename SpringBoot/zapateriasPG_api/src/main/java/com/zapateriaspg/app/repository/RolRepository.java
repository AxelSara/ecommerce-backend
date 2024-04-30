package com.zapateriaspg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriaspg.app.entity.Rol;

public interface RolRepository extends CrudRepository<Rol,Long> {
	Optional<Rol> findById(Long idRol);
}
