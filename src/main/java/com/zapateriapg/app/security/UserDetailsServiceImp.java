package com.zapateriapg.app.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zapateriapg.app.entity.Usuario;
import com.zapateriapg.app.service.UsuarioService;

// STEP 4 Leer el usuario de la DB
@Service
public class UserDetailsServiceImp implements UserDetailsService {

	private UsuarioService userService;
	
	public UserDetailsServiceImp( UsuarioService userService ) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario existingUser = userService.getUsuarioByEmail(email);			
		return new UserDetailsImp( existingUser );
	}

}