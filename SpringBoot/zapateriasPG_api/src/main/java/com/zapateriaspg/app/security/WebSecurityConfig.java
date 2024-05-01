package com.zapateriaspg.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.zapateriaspg.app.security.jwt.JWTAuthenticationFilter;
import com.zapateriaspg.app.security.jwt.JWTAuthorizationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // STEP 1.1 Crear un bean de PassworsEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // STEP 1.2 Crear un bean de SecurityFilterChain
    // SecurityFilterChain se encarga de manejar las solicitudes HTTP y
    // autenticarlas

    @SuppressWarnings("deprecation")
    @Bean
    SecurityFilterChain filterChain(
    HttpSecurity http,
    AuthenticationManager authManager,
    JWTAuthorizationFilter jwtAuthorizationFilter
    
    ) throws Exception {

        
        // STEP 7: Agregamos el filtro de autenticación del login
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(  authManager );
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");


        // STEP 1.3 Configurar las solicitudes HTTP
        http

                //.csrf(csrf -> csrf.disable()) // Deshabilita CSRF para simplificar, pero ten en cuenta las implicaciones de seguridad
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/assets/**", "/api/usuarios/**").permitAll() // Permite el acceso sin autenticación a todas las rutas que comiencen con "/" o "/api/usuarios/"
                                .requestMatchers("/api/roles/**").permitAll()
                                // Solo pueden acceder a las rutas "/api/v1/menuAdmin/**" o "/api/menuAdmin/**" los administradores
                                .requestMatchers("/api/usuarios/**",
										"/api/menuAdmin/**").hasAnyRole("Administrador","ADMIN")
                                .anyRequest().authenticated() // Requiere autenticación para todas las demás rutas
                )

                // STEP 7: Agregamos el filtro de autenticación del login
				// interceptar las solicitudes de autenticación 
				// y generamos el token en la respuesta
				.addFilter(jwtAuthenticationFilter)
				// STEP 8: Agregamos el filtro para las demas solicitudes verificando el token JWT
				// Interceptamos las solicitudes , extraemos y validamos el token
				// y autenticamos al usuario
				.addFilterBefore( jwtAuthorizationFilter  ,  UsernamePasswordAuthenticationFilter.class)				
			    // no es necesario almacenar información de sesión en el servidor, 
				// ya que toda la información necesaria para la autenticación 
				// se encuentra en el token, y cada solicitud es autónoma.				 
				.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf( csrf-> csrf.disable() )
				.httpBasic( withDefaults() ); 
            
        return http.build();

    }

    // STEP 3 Autenticación basada en usuarios de la DB
	/** 
	 *  AuthenticationManager: Gestiona las operaciones de autenticación.
	 *  getSharedObject: Obtiene una instancia compartida de AuthenticationManagerBuilder 
	 *  .userDetailsService: Configura el AuthenticationManagerBuilder 
	 *  	para utilizar un servicio de detalles de usuario personalizado.
	 *  userDetailsService: responsable de cargar detalles específicos 
	 *  	del usuario durante el proceso de autenticación.
	 */	

     @Bean
     AuthenticationManager authManager(
                 HttpSecurity httpSecurity,
                 PasswordEncoder passwordEncoder,
                 UserDetailsService userDetailsService
             
             ) throws Exception {
         
         AuthenticationManagerBuilder authManagerBuilder = httpSecurity
                 .getSharedObject( AuthenticationManagerBuilder.class  );
         
         authManagerBuilder
          .userDetailsService( userDetailsService ) 
          .passwordEncoder( passwordEncoder );
         
         return authManagerBuilder.build();
     }
}

