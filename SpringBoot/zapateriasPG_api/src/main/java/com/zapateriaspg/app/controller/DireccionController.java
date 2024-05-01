package com.zapateriaspg.app.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zapateriaspg.app.entity.Direccion;
import com.zapateriaspg.app.service.DireccionService;
/*
import com.zapateriaspg.app.entity.Usuario;
import com.zapateriaspg.app.service.UsuarioService;
*/

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
    
    @Autowired
    private DireccionService direccionService;
    //private UsuarioService usuarioService;
    
    // Método para obtener una dirección por cliente
    @GetMapping("/{id}")
    public Direccion obtenerDireccionDelUsuario(@PathVariable Long id){
        return direccionService.obtenerDireccionDelUsuario(id);
    }

    // Método para obtener las direcciones de un usuario
    /*
    @GetMapping
    public List<Direccion> obtenerDireccionesDeUnUsuario(@PathVariable Long id) {
        Usuario user = usuarioService.getById(id);
        if(user == null){
            System.out.println("Not found");
            return null; // Cambiar el return
        }
        return direccionService.obtenerDireccionesDeUnUsuario(id);
    }
    */

    // Método para crear una nueva direccion
    @PostMapping
    public Direccion insertarDireccion(@PathVariable Direccion direccion){
        return direccionService.insertarDireccion(direccion);
    }

    // Método para actualizar una dirección
    @PutMapping("/{id}")
    public Direccion actualizarDireccion(@PathVariable Direccion direccion, @PathVariable Long id){
        return direccionService.actualizarDireccion(direccion, id);
    }

    // Método para eliminar una dirección
    @DeleteMapping("{id}")
    public void eliminarDireccion(@PathVariable Long id){
        direccionService.eliminarDireccion(id);
    }
}
