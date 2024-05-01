package com.zapateriaspg.app.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zapateriaspg.app.entity.Usuario;

//STEP 5 Convertir un tipo User a UserDetails
public class UserDetailsImp implements UserDetails {

	private Usuario user;
	
	public UserDetailsImp(Usuario user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add( 
			new SimpleGrantedAuthority( "ROLE_" + this.user.getRol().getNombreRol().toUpperCase() )  
		);
		
		
		return authorities;
	}

	@Override
	public String getPassword() {		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
	}

	// @Override
	// public boolean isEnabled() {
	// 	return user.getActive();
	// }

}