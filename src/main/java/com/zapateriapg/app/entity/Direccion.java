package com.zapateriapg.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="direcciones")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDireccion;
	@Column(name="calle",nullable = false, length = 100)
	private String calle;
	@Column(name="colonia",nullable = false, length = 100)
	private String colonia;
	@Column(name="email",nullable = false, length = 120)
	private String email;
	@Column(name="cp",nullable = false)
	private Long cp;
	@Column(name="delegacionMunicipio",nullable = false, length = 100)
	private String delegacionMunicipio;
	@Column(name="estado",nullable = false, length = 100)
	private String estado;
	@Column(name="indicacionesEspeciales", length = 255)
	private String indicacionesEspeciales;
	@Column(name="noExterior",nullable = false)
	private Long noExterior;
	@Column(name="noInterior")
	private Long noInterior;
	@Column(name="nombreDomicilio",nullable = false, length = 100)
	private String nombreDomicilio;
	@Column(name="nombreUsuario",nullable = false, length = 100)
	private String nombreUsuario;
	@Column(name="telefono",nullable = false, length = 30)
	private String telefono;
	/*
	 * Relaciones entre Entidades: JPA permite definir relaciones 
	 * entre entidades, como relaciones uno a uno, uno a muchos 
	 * y muchos a muchos. Estas relaciones se pueden configurar
	 *  usando anotaciones como @OneToOne, @OneToMany, @ManyToOne y @ManyToMany. 
	 */
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable = false)
	private Usuario usuario;
	public long getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(long idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCp() {
		return cp;
	}
	public void setCp(Long cp) {
		this.cp = cp;
	}
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIndicacionesEspeciales() {
		return indicacionesEspeciales;
	}
	public void setIndicacionesEspeciales(String indicacionesEspeciales) {
		this.indicacionesEspeciales = indicacionesEspeciales;
	}
	public Long getNoExterior() {
		return noExterior;
	}
	public void setNoExterior(Long noExterior) {
		this.noExterior = noExterior;
	}
	public Long getNoInterior() {
		return noInterior;
	}
	public void setNoInterior(Long noInterior) {
		this.noInterior = noInterior;
	}
	public String getNombreDomicilio() {
		return nombreDomicilio;
	}
	public void setNombreDomicilio(String nombreDomicilio) {
		this.nombreDomicilio = nombreDomicilio;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Direccion [idDireccion=");
		builder.append(idDireccion);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", email=");
		builder.append(email);
		builder.append(", cp=");
		builder.append(cp);
		builder.append(", delegacionMunicipio=");
		builder.append(delegacionMunicipio);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", indicacionesEspeciales=");
		builder.append(indicacionesEspeciales);
		builder.append(", noExterior=");
		builder.append(noExterior);
		builder.append(", noInterior=");
		builder.append(noInterior);
		builder.append(", nombreDomicilio=");
		builder.append(nombreDomicilio);
		builder.append(", nombreUsuario=");
		builder.append(nombreUsuario);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}
	


}
