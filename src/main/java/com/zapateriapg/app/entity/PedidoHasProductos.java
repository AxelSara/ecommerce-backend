package com.zapateriapg.app.entity;
import jakarta.persistence.*;

@Entity
@Table(name="pedidoHasProductos")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "PedidoHasProductos [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", getId()=" + getId()
                + ", getPedido()=" + getPedido() + ", getProducto()=" + getProducto() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

   

    
}
