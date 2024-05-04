package com.zapateriapg.app.service;

import com.zapateriapg.app.entity.Rol;

public interface RolService {
	Rol obtenerRolPorId(Long rolId);
    Rol crearRol(Rol rol);
    Rol actualizarRol(Long rolId, Rol rol);
    void eliminarRol(Long rolId);
}
