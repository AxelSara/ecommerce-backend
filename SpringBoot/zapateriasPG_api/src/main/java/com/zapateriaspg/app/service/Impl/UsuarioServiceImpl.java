package com.zapateriaspg.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zapateriaspg.app.entity.Usuario;
import com.zapateriaspg.app.repository.UsuarioRepository;
import com.zapateriaspg.app.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario getById(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        // Verificar si el usuario ya existe en el sistema
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            // Si el usuario ya existe, no se crea
            return null;
        }
        // Si el usuario no existe, se crea
        return usuarioRepository.save(usuario);
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
        } 
        else {
            // Maneja el caso en que el usuario no se encuentra
            return null;
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsuarios'");
    }
}
