package com.zapateriaspg.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRol;
	@Column(name="nombreRol",nullable = false, length = 120)
	private String nombreRol;
	@Column(name="descripcionRol",nullable = false, length = 120)
	private String descripcionRol;
	
	
	public Rol() {
	}
	
	
	//Getters and setters
	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [idRol=");
		builder.append(idRol);
		builder.append(", nombreRol=");
		builder.append(nombreRol);
		builder.append(", descripcionRol=");
		builder.append(descripcionRol);
		builder.append("]");
		return builder.toString();
	}
	

}
