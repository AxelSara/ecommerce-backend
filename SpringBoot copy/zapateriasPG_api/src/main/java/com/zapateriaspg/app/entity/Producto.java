package com.zapateriaspg.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProducto;
	@Column(name="nombreZapato",nullable = false, length = 100)
	private String nombreZapato;
	@Column(name="colorZapato",nullable = false, length = 60)
	private String colorZapato;
	@Column(name="precio",nullable = false)
	private float precio;
	@Column(name="marcaZapato",nullable = false, length = 50)
	private String marcaZapato;
	@Column(name="generoZapato",nullable = false, length = 45)
	private String generoZapato;
	@Column(name="stock",nullable = false)
	private int stock;
	@Column(name="imagenPrincipal",nullable = false, length =255, unique = true) // unique indica que este atributo debe ser unico por cada usuario (no se repite)
	private String imagenPrincipal;
	@Column(name="imagenFrontal",nullable = false, length =255, unique = true) // unique indica que este atributo debe ser unico por cada usuario (no se repite)
	private String imagenFrontal;
	@Column(name="imagenLateral",nullable = false, length =255, unique = true) // unique indica que este atributo debe ser unico por cada usuario (no se repite)
	private String imagenLateral;
	@Column(name="imagenSuperior",nullable = false, length =255, unique = true) // unique indica que este atributo debe ser unico por cada usuario (no se repite)
	private String imagenSuperior;
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreZapato() {
		return nombreZapato;
	}
	public void setNombreZapato(String nombreZapato) {
		this.nombreZapato = nombreZapato;
	}
	public String getColorZapato() {
		return colorZapato;
	}
	public void setColorZapato(String colorZapato) {
		this.colorZapato = colorZapato;
	}
	public float getPrecioZapato() {
		return precio;
	}
	public void setPrecioZapato(float precio) {
		this.precio = precio;
	}
	public String getMarcaZapato() {
		return marcaZapato;
	}
	public void setMarcaZapato(String marcaZapato) {
		this.marcaZapato = marcaZapato;
	}
	public String getGeneroZapato() {
		return generoZapato;
	}
	public void setGeneroZapato(String generoZapato) {
		this.generoZapato = generoZapato;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImagenPrincipal() {
		return imagenPrincipal;
	}
	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}
	public String getImagenFrontal() {
		return imagenFrontal;
	}
	public void setImagenFrontal(String imagenFrontal) {
		this.imagenFrontal = imagenFrontal;
	}
	public String getImagenLateral() {
		return imagenLateral;
	}
	public void setImagenLateral(String imagenLateral) {
		this.imagenLateral = imagenLateral;
	}
	public String getImagenSuperior() {
		return imagenSuperior;
	}
	public void setImagenSuperior(String imagenSuperior) {
		this.imagenSuperior = imagenSuperior;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [idProducto=");
		builder.append(idProducto);
		builder.append(", nombreZapato=");
		builder.append(nombreZapato);
		builder.append(", colorZapato=");
		builder.append(colorZapato);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", marcaZapato=");
		builder.append(marcaZapato);
		builder.append(", generoZapato=");
		builder.append(generoZapato);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", imagenPrincipal=");
		builder.append(imagenPrincipal);
		builder.append(", imagenFrontal=");
		builder.append(imagenFrontal);
		builder.append(", imagenLateral=");
		builder.append(imagenLateral);
		builder.append(", imagenSuperior=");
		builder.append(imagenSuperior);
		builder.append("]");
		return builder.toString();
	}
	

}
