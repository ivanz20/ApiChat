package com.example.users.model;

public class MensajesLista {
	private String username;
	private String fotoperfil;
	private String status;
	private String ultimomensaje;
	private Long idusuario;
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFotoperfil() {
		return fotoperfil;
	}
	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUltimomensaje() {
		return ultimomensaje;
	}
	public void setUltimomensaje(String ultimomensaje) {
		this.ultimomensaje = ultimomensaje;
	}
}
