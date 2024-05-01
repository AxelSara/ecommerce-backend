// package com.zapateriaspg.app.entity;

// import java.time.LocalDateTime;
// import jakarta.persistence.*;

// @Entity
// @Table(name="pedidos")
// public class Pedido {
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private long idPedido;
// 	@Column(name="email",nullable = false, length = 120)
// 	private String email;
// 	@Column(name="fechaPedido",nullable = false)
// 	private LocalDateTime fechaPedido;
// 	@Column(name="monto",nullable = false)
// 	private float monto;
	
// 	/*
// 	 * Relaciones entre Entidades: JPA permite definir relaciones 
// 	 * entre entidades, como relaciones uno a uno, uno a muchos 
// 	 * y muchos a muchos. Estas relaciones se pueden configurar
// 	 *  usando anotaciones como @OneToOne, @OneToMany, @ManyToOne y @ManyToMany. 
// 	 */
// 	@ManyToOne
// 	@JoinColumn(name="idUsuario", nullable = false)
// 	private Usuario usuario;
// 	@ManyToOne
// 	@JoinColumn(name="idDireccion", nullable = false)
// 	private Direccion direccion;
// 	public long getIdPedido() {
// 		return idPedido;
// 	}
// 	public void setIdPedido(long idPedido) {
// 		this.idPedido = idPedido;
// 	}
// 	public String getEmail() {
// 		return email;
// 	}
// 	public void setEmail(String email) {
// 		this.email = email;
// 	}
// 	public LocalDateTime getFechaPedido() {
// 		return fechaPedido;
// 	}
// 	public void setFechaPedido(LocalDateTime fechaPedido) {
// 		this.fechaPedido = fechaPedido;
// 	}
// 	public float getMonto() {
// 		return monto;
// 	}
// 	public void setMonto(float monto) {
// 		this.monto = monto;
// 	}
// 	public Usuario getUsuario() {
// 		return usuario;
// 	}
// 	public void setUsuario(Usuario usuario) {
// 		this.usuario = usuario;
// 	}
// 	public Direccion getDireccion() {
// 		return direccion;
// 	}
// 	public void setDireccion(Direccion direccion) {
// 		this.direccion = direccion;
// 	}
// 	@Override
// 	public String toString() {
// 		StringBuilder builder = new StringBuilder();
// 		builder.append("Pedido [idPedido=");
// 		builder.append(idPedido);
// 		builder.append(", email=");
// 		builder.append(email);
// 		builder.append(", fechaPedido=");
// 		builder.append(fechaPedido);
// 		builder.append(", monto=");
// 		builder.append(monto);
// 		builder.append(", usuario=");
// 		builder.append(usuario);
// 		builder.append(", direccion=");
// 		builder.append(direccion);
// 		builder.append("]");
// 		return builder.toString();
// 	}
	

// }
