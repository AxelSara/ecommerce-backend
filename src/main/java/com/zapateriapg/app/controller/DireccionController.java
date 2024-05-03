package com.zapateriapg.app.controller;
import java.util.List;
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
import com.zapateriapg.app.service.DireccionService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
	
    //@Autowired
	DireccionService direccionService;
	
	 // Metodo para obtener una direccion por ID
    @GetMapping("/{id}")
    public Direccion obtenerDireccionDelUsuario(@PathVariable Long id) {
        return direccionService.obtenerDireccionDelUsuario(id);
    }

    // Metodo para crear una nueva direccion
    @PostMapping
    public ResponseEntity<Direccion> insertarDireccion(@RequestBody Direccion direccion) {
        Direccion crearDireccion = direccionService.insertarDireccion(direccion);
        return new ResponseEntity<Direccion>(crearDireccion, HttpStatus.CREATED);
    }

    // Metodo para obtener todas las direcciones
    @GetMapping
    public List<Direccion> obtenerDireccionesDeUnUsuario(@PathVariable Long id) {
        return direccionService.obtenerDireccionesDeUnUsuario(id);
    }

    // Metodo para actualizar una direccion existente
    @PutMapping("/{id}")
    public Direccion actualizarDireccion(@RequestBody Direccion direccion, @PathVariable Long id) {
        return direccionService.actualizarDireccion(direccion, id);
    }

    // Metodo para eliminar una direccion
    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Long id) {
        direccionService.eliminarDireccion(id);
    }
}