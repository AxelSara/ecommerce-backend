package com.zapateriapg.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapateriapg.app.entity.PedidoHasProductos;
import com.zapateriapg.app.repository.PedidoHasProductosRepository;
import com.zapateriapg.app.service.PedidoHasProductosService;

@Service
public class PedidoHasProductosImpl implements PedidoHasProductosService {

    @Autowired
    PedidoHasProductosRepository pedidoHasProductosRepository;

    @Override
    public
    PedidoHasProductos obtenerPedidoHasProductosById(Long id) {
        Optional<PedidoHasProductos> pedidoHasProductosOptional = pedidoHasProductosRepository.findById(id);

        if (pedidoHasProductosOptional.isPresent()) {
            return pedidoHasProductosOptional.get();
        } else {
            throw new IllegalStateException("El pedido con el id " + id + " no existe.");
        }
    }

    @Override
    public List<PedidoHasProductos> obtenerTodosPedidosHasProductos() {
        return (List<PedidoHasProductos>) pedidoHasProductosRepository.findAll();
    }

    @Override
    public PedidoHasProductos insertarPedidoHasProductos(PedidoHasProductos pedidoHasProductos) {
        return pedidoHasProductosRepository.save(pedidoHasProductos);
    }

    @Override
    public PedidoHasProductos actualizarPedidoHasProductos(PedidoHasProductos pedidoHasProductos, Long id) {
        Optional<PedidoHasProductos> pedidoHasProductosOptional = pedidoHasProductosRepository.findById(id);
        if (pedidoHasProductosOptional.isPresent()) {
            // establecer bien los campos
            pedidoHasProductos.setId(id);
            return pedidoHasProductosRepository.save(pedidoHasProductos);
        } else {
            throw new IllegalStateException("El pedido con el id " + id + " no existe.");
        }
    }

    @Override
    public void deletePedidoHasProductos(Long id) {
        pedidoHasProductosRepository.deleteById(id);
    }



}