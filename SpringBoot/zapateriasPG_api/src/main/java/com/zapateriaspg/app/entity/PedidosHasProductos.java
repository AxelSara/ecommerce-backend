package com.zapateriaspg.app.entity;

import jakarta.persistence.*;
@Entity
@Table(name="pedidosHasProductos")
public class PedidosHasProductos {
	@ManyToMany
	@JoinColumn(name="idPedido", nullable = false)
	private Pedido pedido;
	@ManyToMany
	@JoinColumn(name="idProducto", nullable = false)
	private Producto producto;

}
