package com.zapateriapg.app.entity;
import jakarta.persistence.*;

@Entity
@Table(name="pedidosHasProductos")
public class PedidoHasProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    private Producto producto;

    // Constructor, getters y setters
}
