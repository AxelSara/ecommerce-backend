package com.zapateriaspg.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.zapateriaspg.app.entity.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario , Long > {	
	Optional<Usuario> findByEmail(String email);
	Iterable<Usuario> findAll();
}
