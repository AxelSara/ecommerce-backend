package com.zapateriapg.app.service;

import java.util.List;
import java.util.Optional;

import com.zapateriapg.app.entity.PedidoHasProductos;

public interface PedidosHasProductosService {

    Optional<PedidoHasProductos> getBolsaHasProductosById(Long id);
    List<PedidoHasProductos> getAllBolsaHasProductos(); 
    PedidoHasProductos saveBolsaHasProductos(PedidoHasProductos pedidoHasProductos);
    void deleteBolsaHasProductos(Long id);
    

}
