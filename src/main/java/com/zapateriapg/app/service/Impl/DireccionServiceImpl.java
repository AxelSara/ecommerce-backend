package com.zapateriapg.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapateriapg.app.entity.Direccion;
import com.zapateriapg.app.entity.Usuario;
import com.zapateriapg.app.repository.DireccionRepository;
import com.zapateriapg.app.repository.UsuarioRepository;
import com.zapateriapg.app.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{
    @Autowired
    DireccionRepository direccionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }


    @Override
    public Direccion obtenerDireccionDelUsuario(long id) {
        Optional<Direccion> direccionOptional = direccionRepository.findById(id);
        if (direccionOptional.isPresent()) {
            return direccionOptional.get();
        }
        else{
            throw new IllegalStateException("La Direccion con el usuario de id " + id + " no existe");
        }
    }

    
    @Override
    public List<Direccion> obtenerDireccionesDeUnUsuario(Long id) {
        return (List<Direccion>) direccionRepository.findAll();
    }

    @Override
    public Direccion insertarDireccion(Direccion direccion) {
    // Verificar si el Usuario asociado existe
    Optional<Usuario> usuarioOptional = usuarioRepository.findById(direccion.getUsuario().getIdUsuario());
    if (!usuarioOptional.isPresent()) {
        throw new IllegalStateException("El Usuario con id " + direccion.getUsuario().getIdUsuario() + " no existe");
    }

    // Si el Usuario existe, proceder con la inserción de la dirección
    direccion.setCalle(direccion.getCalle());
    direccion.setColonia(direccion.getColonia());
    direccion.setCp(direccion.getCp());
    direccion.setDelegacionMunicipio(direccion.getDelegacionMunicipio());
    direccion.setEmail(direccion.getEmail());
    direccion.setEstado(direccion.getEstado());
    direccion.setIndicacionesEspeciales(direccion.getIndicacionesEspeciales());
    direccion.setNoExterior(direccion.getNoExterior());
    direccion.setNoInterior(direccion.getNoInterior());
    direccion.setNombreDomicilio(direccion.getNombreDomicilio());
    direccion.setNombreUsuario(direccion.getNombreUsuario());
    direccion.setTelefono(direccion.getTelefono());

    return direccionRepository.save(direccion);
}


   @Override
   public Direccion actualizarDireccion(Direccion direccion, long id) {
    
        Direccion direccionActualizada = obtenerDireccionDelUsuario(id);
        direccionActualizada.setCalle(null);
        direccionActualizada.setColonia(null);;
        direccionActualizada.setCp(null);
        direccionActualizada.setDelegacionMunicipio(null);
        direccionActualizada.setEmail(null);
        direccionActualizada.setEstado(null);
        direccionActualizada.setIndicacionesEspeciales(null);
        direccionActualizada.setNoExterior(null);
        direccionActualizada.setNoInterior(null);
        direccionActualizada.setNombreDomicilio(null);
        direccionActualizada.setNombreUsuario(null);
        direccionActualizada.setTelefono(null);
        direccionActualizada.setUsuario(direccion.getUsuario());
        return direccionRepository.save(direccionActualizada);
   }

    @Override
    public void eliminarDireccion(long id) {
        Direccion direccionExistente  = obtenerDireccionDelUsuario(id);
        direccionRepository.delete(direccionExistente);
    }

}
