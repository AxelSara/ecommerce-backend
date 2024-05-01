package com.zapateriaspg.app.service;

import java.util.List;

import com.zapateriaspg.app.entity.Usuario;

public interface UsuarioService {
	Usuario getById(long id);
	Usuario getUsuarioByEmail(String email);
	Usuario createUsuario(Usuario Usuario);
	List<Usuario> getAllUsuarios();
	Usuario updateUsuario(Usuario Usuario, Long id);
	void deleteUsuario(Long id); 

}
