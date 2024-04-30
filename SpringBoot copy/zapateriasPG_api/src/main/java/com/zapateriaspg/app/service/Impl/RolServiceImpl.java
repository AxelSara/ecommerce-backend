package com.zapateriaspg.app.service.Impl;

import java.util.Optional;

import com.zapateriaspg.app.entity.Rol;
import com.zapateriaspg.app.repository.RolRepository;
import com.zapateriaspg.app.service.RolService;

public class RolServiceImpl implements RolService {

    RolRepository rolRepository;

    public RolServiceImpl(){}

    @Override
    public Rol obtenerRolPorId(Long rolId) {
        Optional<Rol> optionalRol = rolRepository.findById(rolId);
        return optionalRol.orElse(null);
    }

    @Override
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol actualizarRol(Long rolId, Rol rol) {
        if (rolRepository.existsById(rolId)) {
            rol.setIdRol(rolId);
            return rolRepository.save(rol);
        }
        return null;
    }

    @Override
    public void eliminarRol(Long rolId) {
        rolRepository.deleteById(rolId);
    }


}