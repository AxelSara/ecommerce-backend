package com.zapateriaspg.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zapateriaspg.app.entity.Rol;
import com.zapateriaspg.app.service.RolService;

@RestController
@RequestMapping("api/roles")
public class RolController {
	

	RolService rolService;


    // Método para obtener un rol por ID usando la anotación @getMapping con el path "/{rolId}"
    @GetMapping("{rolId}")
    public Rol obtenerRolPorIdController(@PathVariable ("rolId") Long rolId) {
        return rolService.obtenerRolPorId(rolId);
    }

    @PostMapping
    public Rol crearRolController(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @PutMapping("{rolId}")
    public Rol actualizarRolController(@PathVariable Long rolId, @RequestBody Rol rol) {
        return rolService.actualizarRol(rolId, rol);
    }

    @DeleteMapping("{rolId}")
    public void eliminarRolController(@PathVariable Long rolId) {
        rolService.eliminarRol(rolId);
    }

}