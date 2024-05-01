// package com.zapateriaspg.app.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.zapateriaspg.app.security.jwt.JWTAuthenticationFilter;
// import com.zapateriaspg.app.security.jwt.JWTAuthorizationFilter;

// import static org.springframework.security.config.Customizer.withDefaults;

// import java.util.List;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {

//     // STEP 1.1 Crear un bean de PassworsEncoder
//     @Bean
//     PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // public static void main(String[] args) {
//     //     System.out.println("===================================");
// 	// 	System.out.println( new BCryptPasswordEncoder().encode("123")  );
// 	// }

//     // STEP 1.2 Crear un bean de SecurityFilterChain
//     // SecurityFilterChain se encarga de manejar las solicitudes HTTP y
//     // autenticarlas

//     @Bean
// 	SecurityFilterChain filterChain( 
// 			HttpSecurity http,
// 			AuthenticationManager authManager,
// 			JWTAuthorizationFilter jwtAuthorizationFilter
// 			) throws Exception {
		
// 		// STEP 7.3 Crear el objeto y la configuración para jwtAuthenticationFilter
// 		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
// 		jwtAuthenticationFilter.setAuthenticationManager(  authManager );
// 		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		
// 		// STEP 2.1 Deshabilitar la seguridad
// 		/*return http
// 				.authorizeHttpRequests( authorize -> authorize.anyRequest().permitAll() )
// 				.csrf( csrf-> csrf.disable() )
// 				.httpBasic( withDefaults() ) 
// 				.build(); */
		
// 		// STEP 2.2 PErsonalizar la seguridad en los endpoints

// 		return http
// 				.authorizeHttpRequests( authorize -> authorize
// 						.requestMatchers("/", "index.html", "/assets/**").permitAll()
// 						.requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
// 						.requestMatchers(HttpMethod.GET, "/api/v1/products","/api/v1/products/**").permitAll()
// 						.requestMatchers("/api/usuarios", "/api/roles/**").hasRole("ADMINISTRADOR")
// 						.requestMatchers("/api/usuarios/**",
// 										"/api/v1/purchases/**",
// 										"/api/v1/order-has-products/**"
// 								).hasAnyRole("ADMINISTRADOR","CLIENTE")
// 						.anyRequest().authenticated()						
// 						)
// 				// STEP 7: Agregamos el filtro de autenticación del login
// 				// interceptar las solicitudes de autenticación 
// 				// y generamos el token en la respuesta
// 				.addFilter(jwtAuthenticationFilter)
// 				// STEP 8: Agregamos el filtro para las demas solicitudes verificando el token JWT
// 				// Interceptamos las solicitudes , extraemos y validamos el token
// 				// y autenticamos al usuario
// 				.addFilterBefore( jwtAuthorizationFilter  ,  UsernamePasswordAuthenticationFilter.class)				
// 			    // no es necesario almacenar información de sesión en el servidor, 
// 				// ya que toda la información necesaria para la autenticación 
// 				// se encuentra en el token, y cada solicitud es autónoma.				 
// 				.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// 				.csrf( csrf-> csrf.disable() )
// 				.httpBasic( withDefaults() ) 
// 				.build();
		
// 	}
	

//     // STEP 3 Autenticación basada en usuarios de la DB
// 	/** 
// 	 *  AuthenticationManager: Gestiona las operaciones de autenticación.
// 	 *  getSharedObject: Obtiene una instancia compartida de AuthenticationManagerBuilder 
// 	 *  .userDetailsService: Configura el AuthenticationManagerBuilder 
// 	 *  	para utilizar un servicio de detalles de usuario personalizado.
// 	 *  userDetailsService: responsable de cargar detalles específicos 
// 	 *  	del usuario durante el proceso de autenticación.
// 	 */	

//      @Bean
//      AuthenticationManager authManager(
//                  HttpSecurity httpSecurity,
//                  PasswordEncoder passwordEncoder,
//                  UserDetailsService userDetailsService
             
//              ) throws Exception {
         
//          AuthenticationManagerBuilder authManagerBuilder = httpSecurity
//                  .getSharedObject( AuthenticationManagerBuilder.class  );
         
//          authManagerBuilder
//           .userDetailsService( userDetailsService ) 
//           .passwordEncoder( passwordEncoder );
         
//          return authManagerBuilder.build();
//      }
//     @Bean
// 	CorsConfigurationSource corsConfigurationSource() {
// 		CorsConfiguration configuration = new CorsConfiguration();
// 		configuration.setAllowedOrigins( List.of("http://127.0.0.1:5500", "https://ecommer-generica.netlify.app") );
// 		configuration.setAllowedMethods( List.of("GET", "POST", "PUT", "DELETE") );
// 		configuration.setAllowedHeaders( List.of("Authorization","Content-Type") );
		
// 		// Para todas las rutas en la aplicación ("/**"), 
// 		// aplique la configuración CORS definida en el objeto configuration.
// 		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// 		source.registerCorsConfiguration("/**", configuration);
// 		return source;
			
// 	}
	
// }

