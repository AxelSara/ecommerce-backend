package com.zapateriaspg.app.service;

import com.zapateriaspg.app.entity.Rol;

public interface RolService {
	Rol obtenerRolPorId(Long rolId);
    Rol crearRol(Rol rol);
    Rol actualizarRol(Long rolId, Rol rol);
    void eliminarRol(Long rolId);
}
