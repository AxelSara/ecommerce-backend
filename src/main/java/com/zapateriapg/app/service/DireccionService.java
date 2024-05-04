package com.zapateriapg.app.service;

import java.util.List;
import com.zapateriapg.app.entity.Direccion;


public interface DireccionService {
    Direccion obtenerDireccionDelUsuario(long id);
    List<Direccion> obtenerDireccionesDeUnUsuario(Long id);
    Direccion insertarDireccion(Direccion direccion);
    Direccion actualizarDireccion(Direccion direccion, long id);
    void eliminarDireccion(long id);
}
