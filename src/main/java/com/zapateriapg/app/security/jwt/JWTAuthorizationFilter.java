package com.zapateriapg.app.security.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends  OncePerRequestFilter {

	// STEP 8.1 extraer el token del header (Autorizacion de la solicitud )
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Lee la parte de  de la autenticación 
		String bearerToken = request.getHeader("Authorization");
		
		if ( bearerToken != null && bearerToken.startsWith("Bearer ") ) {
			String token = bearerToken.replace("Bearer ", "");
			UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token) ; 
			SecurityContextHolder.getContext().setAuthentication( usernamePAT );
		} else {
			//throw new IllegalStateException("Se requiere de un token");
		
	}
		
		filterChain.doFilter(request, response);
		
	}
}