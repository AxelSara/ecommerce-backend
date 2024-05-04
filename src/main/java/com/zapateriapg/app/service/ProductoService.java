package com.zapateriapg.app.service;

import java.util.List;
import com.zapateriapg.app.entity.Producto;

public interface ProductoService {
    Producto obtenerProductoPorId(long id);
    List<Producto> obtenerTodosLosProductos();
    Producto insertarProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    void borrarProducto(long id);
} 

