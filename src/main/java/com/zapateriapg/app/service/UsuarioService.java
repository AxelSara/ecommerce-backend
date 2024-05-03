package com.zapateriapg.app.service;

import java.util.List;

import com.zapateriapg.app.entity.Usuario;

public interface UsuarioService {
	Usuario getById(long id);
	Usuario getUsuarioByEmail(String email);
	Usuario createUsuario(Usuario Usuario);
	List<Usuario> getAllActiveUsers();
	List<Usuario> getAllInactiveUsers();
	List<Usuario> getAllUsuarios(boolean isActive);
	Usuario updateUsuario(Usuario Usuario, Long id);
	void deleteUsuario(Long id); 

}
