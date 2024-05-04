package com.zapateriapg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zapateriapg.app.entity.Usuario;
import com.zapateriapg.app.service.UsuarioService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // Método para obtener un usuario por ID
	@GetMapping("/{id}") // localhost:8080/api/v1/users/{id}
	ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id ){
		return new ResponseEntity<Usuario>(usuarioService.getById(id) ,HttpStatus.OK );
	}

    // Método para obtener un usuario por correo electrónico
    @GetMapping("/email/{email}")
    public Usuario getUsuarioByEmail(@PathVariable String email) {
        return usuarioService.getUsuarioByEmail(email);
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario crearUsuario = usuarioService.createUsuario(usuario);
        // return usuarioService.createUsuario(usuario);
        return new ResponseEntity<Usuario>( crearUsuario, HttpStatus.CREATED );	
    }

    // @PostMapping
	// ResponseEntity<User> createUser(@RequestBody User user ){
	// 	User createdUser = userService.createUser(user);
		
	// 	return new ResponseEntity<User>( createdUser, HttpStatus.CREATED );		
	// }

    // Método para obtener todos los usuarios
	@GetMapping 
	 ResponseEntity< List<Usuario> > getAllUsers(
			@RequestParam(	name="active", 
							required=false, 
							defaultValue="true") boolean active 
			){
		return new ResponseEntity<List<Usuario>>(usuarioService.getAllUsuarios( active ), HttpStatus.OK);
    }
    // Método para actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.updateUsuario(usuario, id);
    }

    // Método para eliminar un usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
