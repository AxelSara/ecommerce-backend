package com.zapateriapg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zapateriapg.app.entity.*;
import com.zapateriapg.app.service.RolService;
import com.zapateriapg.app.service.UsuarioService;

@RestController
@RequestMapping("api/roles")
public class RolController {
	
    @Autowired
	RolService rolService;

    @Autowired
    UsuarioService usuarioService;

    
    public RolController(UsuarioService usuarioService) {
       this.usuarioService = usuarioService;
    }

    @GetMapping 
	 ResponseEntity< List<Usuario> > getAllUsers(
			@RequestParam(	name="active", 
							required=false, 
							defaultValue="true") boolean active 
			)
    {
		return new ResponseEntity<List<Usuario>>(usuarioService.getAllUsuarios( active ), HttpStatus.OK);
    }

    // Método para obtener un rol por ID usando la anotación @getMapping con el path "/{rolId}"
    @GetMapping("{rolId}")
    public Rol obtenerRolPorId(@PathVariable ("rolId") Long rolId) {
        return rolService.obtenerRolPorId(rolId);
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @PutMapping("{rolId}")
    public Rol actualizarRol(@PathVariable Long rolId, @RequestBody Rol rol) {
        return rolService.actualizarRol(rolId, rol);
    }

    @DeleteMapping("{rolId}")
    public void eliminarRol(@PathVariable Long rolId) {
        rolService.eliminarRol(rolId);
    }

}