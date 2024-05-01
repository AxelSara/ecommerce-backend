package com.zapateriapg.app.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zapateriapg.app.entity.Rol;
import com.zapateriapg.app.repository.RolRepository;
import com.zapateriapg.app.service.RolService;
@Service
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