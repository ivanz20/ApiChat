package com.example.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class User {
	
	public User() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombres_usuario", nullable = false)
	private String nombres;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getFotoperfil() {
		return fotoperfil;
	}

	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}

	@Column(name="apellidos_usuario", nullable = false)
	private String apellidos;
	
	@Column(name="email_usuario", nullable = false)
	private String email;
	
	@Column(name="password_usuario", nullable = false)
	private String password;
	
	@Column(name="foto_usuario", nullable = false)
	private String fotoperfil;
	
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="status", nullable = false)
	private String status = "offline";


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
