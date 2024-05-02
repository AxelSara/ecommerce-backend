package com.zapateriapg.app.security.jwt;



// STEP 2. Crear la clase AuthCredentials que contendra los atributos email y password 
// que seran enviados por el frontend
public class AuthCredentials {
	
	private String email;
	private String password;
	
	public AuthCredentials() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}