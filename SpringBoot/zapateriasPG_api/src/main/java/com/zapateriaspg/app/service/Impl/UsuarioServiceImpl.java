package com.zapateriaspg.app.service.Impl;

// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.zapateriaspg.app.entity.Usuario;
import com.zapateriaspg.app.repository.UsuarioRepository;
import com.zapateriaspg.app.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;
    // PasswordEncoder passwordEncoder;

    // public UsuarioServiceImpl( UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
    //     this.usuarioRepository = usuarioRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    @Override
    public Usuario getUserById(long id) {
        
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

    @Override
	public Usuario createUsuario(Usuario user) {	
		user.setActive(true);
		user.setIdUsuario(0);
		user.setPassword(user.getPassword());


		// user.setRole( new Role(1) );
		// user.setPassword( passwordEncoder.encode( user.getPassword() ) );
		
		if( usuarioRepository.existsByEmail(user.getEmail()) ) {
			throw new IllegalStateException(" El usuario con el email " + user.getEmail());
		}
        // // imprmir user
        // System.out.println("Usuario a crear: " + user);
					
		return usuarioRepository.save(user);
	}

    @Override
    public Usuario updateUsuario(Usuario usuario, Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
            // Actualiza otros campos según sea necesario...
            return usuarioRepository.save(usuarioExistente);
        } 
        else {
            // Maneja el caso en que el usuario no se encuentra
            return null;
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        Usuario existingUser = getUserById(id);		
		existingUser.setActive(false);
		usuarioRepository.save(existingUser);
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
	public List<Usuario> getAllUsers(boolean isActive) {
		if( isActive ) return getAllActiveUsers();
		else return getAllInactiveUsers();		
	}

}
