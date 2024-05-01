package com.zapateriaspg.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zapateriaspg.app.entity.Usuario;
import com.zapateriaspg.app.service.UsuarioService;
import java.util.List;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    UsuarioService usuarioService;


    // Método para obtener todos los usuarios
    @GetMapping
    // public List<Usuario> getAllUsuarios() {
    //     return usuarioService.getAllUsuarios();
    // }
    ResponseEntity< List<Usuario> > getAllUsers(
            @RequestParam(	name="active", 
                            required=false, 
                            defaultValue="true") boolean active 
            ){
        return new ResponseEntity<List<Usuario>>(usuarioService.getAllUsers( active ), HttpStatus.OK);
    }

    // Método para obtener un usuario por ID
    @GetMapping("{id}")
    ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id) {
        return new ResponseEntity<Usuario>(usuarioService.getUserById(id), HttpStatus.OK);
    }

    // Método para obtener un usuario por correo electrónico
    @GetMapping("/email/{email}")
    Usuario getUsuarioByEmail(@PathVariable String email) {
        return usuarioService.getUsuarioByEmail(email);
    }

    // Método para crear un nuevo usuario
    @PostMapping
    ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario crearUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<Usuario>(crearUsuario, HttpStatus.CREATED);
    }


    // Método para actualizar un usuario existente
	@PutMapping("{id}")
	ResponseEntity<Usuario> updateUser(
			@RequestBody Usuario user, 
			@PathVariable("id") Long id  
			){
		Usuario updatedUser = usuarioService.updateUsuario(user, id);
		
		return new ResponseEntity<Usuario>(updatedUser, HttpStatus.OK);
    }
    // Método para eliminar un usuario
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteUser(@PathVariable("id") Long id ){
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<String>("User id " + id + " successfully deleted", HttpStatus.OK);
	}
}
