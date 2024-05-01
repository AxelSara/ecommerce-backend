package com.zapateriaspg.app.service;

import java.util.List;

import com.zapateriaspg.app.entity.Usuario;

public interface UsuarioService {
	Usuario getUserById(long id);
	Usuario getUsuarioByEmail(String email);
	Usuario createUsuario(Usuario Usuario);
	List<Usuario> getAllActiveUsers();
	List<Usuario> getAllInactiveUsers();
	List<Usuario> getAllUsers(boolean isActive);
	Usuario updateUsuario(Usuario Usuario, Long id);
	void deleteUsuario(Long id); 
}
