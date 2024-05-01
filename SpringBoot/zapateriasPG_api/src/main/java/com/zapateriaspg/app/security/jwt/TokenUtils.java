package com.zapateriaspg.app.security.jwt;
// import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Base64;
import java.util.Collection;
import java.util.Date;
// import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;


	// STEP 7.1 Generación del token JWT
    // public static String generarToken() {
    //     try {
    //         // return token;
	// 		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
    //         keyGenerator.init(256); // Tamaño de la clave en bits
    //         SecretKey secretKey = keyGenerator.generateKey();
    //         return Base64.getEncoder().encodeToString(secretKey.getEncoded());


    //     } catch (NoSuchAlgorithmException e) {
    //         System.err.println("Error al generar la clave secreta: " + e.getMessage());
    //         return null;
	// 	}

	// }



public class TokenUtils {
	
	// private final static String ACCESS_TOKEN_SECRET = "9i3DZ1KONQ5VET8vWXl7EfaT+Ws2b9Bv+okkT7f6DBo=";
	private final static String ACCESS_TOKEN_SECRET = "2e58420b7a254484a496f8a5ac38f8f52e58420b7a254484a496f8a5ac38f8f5";
	private final static long ACCESS_TOKEN_VALID_SECONDS = 900L;

	// STEP 7.1 Crear el token
	public static String createToken(
			String name, 
			String email, 
			Collection<? extends GrantedAuthority> authorities  ) {
		
		
		Date expirationDate = new Date( System.currentTimeMillis() + ACCESS_TOKEN_VALID_SECONDS * 1000 );
		SecretKey secretKey = Keys.hmacShaKeyFor( Decoders.BASE64.decode(ACCESS_TOKEN_SECRET ));
		
		// Datos extras en el payload
		Map<String , Object > extra = new HashMap<>();
		extra.put("name", name  );
		extra.put("authorities", authorities);
		
		// Generación del token JWT
		return Jwts
				.builder()
				.subject(email)
				.expiration(expirationDate)
				.claims(extra)
				.signWith(secretKey)
				.compact();	
		
	}



	// STEP 8.2 Verificar el token
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		
		UsernamePasswordAuthenticationToken userAuth;
		
		SecretKey secretKey = Keys.hmacShaKeyFor( Decoders.BASE64.decode(ACCESS_TOKEN_SECRET ));
		try {
			Claims claims = Jwts
					.parser()
					.verifyWith(secretKey)
					.build()
					.parseSignedClaims(token)
					.getPayload();
			
			String email = claims.getSubject();
			@SuppressWarnings("unchecked")
			List< Map<String,String> > authoritiesList =  (List<Map<String, String>>) claims.get("authorities");
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			for( Map<String, String> authorityMap : authoritiesList  ) {
				String authority = authorityMap.get("authority");
				authorities.add( new SimpleGrantedAuthority(authority)    );
			}

			userAuth = new UsernamePasswordAuthenticationToken(email, null, authorities);
			return userAuth;
		
			
		} catch (JwtException e) {
			throw new IllegalStateException("Problemas con el token");			
		}		
	}

}