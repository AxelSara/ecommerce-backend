 package com.zapateriapg.app.service.Impl;

 import java.util.List;
 import java.util.Optional;

 import com.zapateriapg.app.entity.Direccion;
 import com.zapateriapg.app.repository.DireccionRepository;
 import com.zapateriapg.app.service.DireccionService;

 public class DireccionServiceImpl implements DireccionService{

     DireccionRepository direccionRepository;

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
        
         direccion.setCalle(null);
         direccion.setColonia(null);;
         direccion.setCp(null);
         direccion.setDelegacionMunicipio(null);
         direccion.setEmail(null);
         direccion.setEstado(null);
         direccion.setIndicacionesEspeciales(null);
         direccion.setNoExterior(null);
         direccion.setNoInterior(null);
         direccion.setNombreDomicilio(null);
         direccion.setNombreUsuario(null);
         direccion.setTelefono(null);
        
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
         return direccionRepository.save(direccionActualizada);
    }

     @Override
     public void eliminarDireccion(long id) {
         Direccion direccionExistente  = obtenerDireccionDelUsuario(id);
         direccionRepository.delete(direccionExistente);
     }

 }
