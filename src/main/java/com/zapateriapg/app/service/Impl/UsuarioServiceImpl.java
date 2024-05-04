package com.zapateriapg.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.zapateriapg.app.entity.Usuario;
import com.zapateriapg.app.repository.UsuarioRepository;
import com.zapateriapg.app.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // @Override
    // public Usuario getById(long id) {
    //     Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
    //     return usuarioOptional.orElse(null);
    // }

    @Override
	public Usuario getById(long id) {		
		Optional<Usuario> userOptional = usuarioRepository.findById(id);
		Usuario existingUser;
		
		if( userOptional.isPresent() ) {
			existingUser = userOptional.get();
			return existingUser;
		} else {
			throw new IllegalStateException("User does not exist with id " + id);
		}			
	}

    


    @Override
	public Usuario getUsuarioByEmail(String email) {
		Optional<Usuario> userOptional = usuarioRepository.findByEmail(email);
		Usuario existingUser;
		
		if( userOptional.isPresent() ) {
			existingUser = userOptional.get();
			return existingUser;
		} else {
			throw new IllegalStateException("User does not exist with email " + email);
		}	
	}

    // @Override
    // public Usuario createUsuario(Usuario usuario) {
    //     return usuarioRepository.save(usuario);
    // }

    @Override
	public Usuario createUsuario(Usuario user) {	
		user.setActive(true);
		user.setIdUsuario(0);
		// user.setRole( new Role(1) );
		user.setPassword( passwordEncoder.encode( user.getPassword() ) );
		
		if( usuarioRepository.existsByEmail(user.getEmail()) ) {
			throw new IllegalStateException("User exist with email " + user.getEmail());
		}
					
		return usuarioRepository.save(user);
	}






    // @Override
    // public List<Usuario> getAllUsuarios() {
    //     return usuarioRepository.findAll();
    // }

    @Override
    public Usuario updateUsuario(Usuario usuario, Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
            // Actualiza otros campos según sea necesario...
            return usuarioRepository.save(usuarioExistente);
        } else {
            // Maneja el caso en que el usuario no se encuentra
            return null;
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
	public List<Usuario> getAllActiveUsers() {		
		return (List<Usuario>) usuarioRepository.findAllByActiveTrue();
	}

	@Override
	public List<Usuario> getAllInactiveUsers() {
		return (List<Usuario>) usuarioRepository.findAllByActiveFalse();
	}

    @Override
    public List<Usuario> getAllUsuarios(boolean isActive) {
        if( isActive ) return getAllActiveUsers();
		else return getAllInactiveUsers();		
    }

    
}
