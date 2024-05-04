package com.zapateriapg.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zapateriapg.app.entity.Direccion;
// import com.zapateriapg.app.entity.Usuario;
import com.zapateriapg.app.service.DireccionService;
// import com.zapateriapg.app.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
	
    @Autowired
	DireccionService direccionService;
    // UsuarioService usuarioService;
	
    // Para obtener una dirección específica
    @GetMapping("/{id}/detalle")
    public Direccion obtenerDireccionDelUsuarioController(@PathVariable Long id) {
        return direccionService.obtenerDireccionDelUsuario(id);
    }
    
    // Para obtener todas las direcciones de un usuario
    @GetMapping("/{id}/todas")
    public List<Direccion> obtenerTodasLasDireccionesDeUnUsuarioController(@PathVariable Long id) {
        return direccionService.obtenerDireccionesDeUnUsuario(id);
    }
    // Metodo para crear una nueva direccion

        // Método para crear una nueva dirección
    @PostMapping
    public ResponseEntity<Direccion> insertarDireccionController( @RequestBody Direccion direccion) {
        // try {
        //     // Buscar el usuario por ID
        //     Usuario usuario = usuarioService.getById(id);
        //     if (usuario == null) {
        //         return ResponseEntity.notFound().build();
        //     }
        //     // Obtener las direcciones del usuario
        //     List<Direccion> direcciones = direccionService.obtenerDireccionesDeUnUsuario(usuario.getIdUsuario());
        //     if (direcciones.isEmpty()) {
        //         return ResponseEntity.ok().body("No se encontraron direcciones para el usuario con ID: " + id);
        //     }
        //     return ResponseEntity.ok(direcciones);
        // } catch (Exception e) {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las direcciones del usuario");
        // }
        Direccion crearDireccion = direccionService.insertarDireccion(direccion);
        return new ResponseEntity<Direccion>(crearDireccion, HttpStatus.CREATED);

    }



    // Metodo para actualizar una direccion existente
    @PutMapping("/{id}")
    public Direccion actualizarDireccionController(@RequestBody Direccion direccion, @PathVariable Long id) {
        return direccionService.actualizarDireccion(direccion, id);
    }

    //Metodo para eliminar una direccion
    @DeleteMapping("/{id}")
    public void eliminarDireccionController(@PathVariable Long id) {
        direccionService.eliminarDireccion(id);
    }
}