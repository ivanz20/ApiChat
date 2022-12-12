package com.example.users.model;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mensajes")
public class Mensajes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idmensaje;
	
	@Column (name="id_chat", nullable=true)
	private long id_chat;
	
	@Column (name="message", nullable=true)
	private String message;
	
	@Column (name="archivo_enviado", nullable=true)
	private String mensaje_archivo;
	
	@Column (name="fecha_enviado", nullable = true)
	private Timestamp fecha_enviado;
	

	@Column (name="status", nullable = true)
	private Status status;
	
	@Column(name="sender_name", nullable = true)
	private String sender_name;
	
	@Column(name="receiver_name", nullable = true)
	private String receiver_name;
	
	@Column(name="statususer", nullable = true)
	private String statususer;
	 
	@Column(name="latitud", nullable = true)
	private Float latitud;

	@Column(name="longitud", nullable = true)
	private Float longitud;
	
	@Column(name="encriptado", nullable = false)
	private Boolean encriptado = false;

	@Column(name="tipo_archivo", nullable = true)
	private String tipo_archivo;
	


	public String getTipo_archivo() {
		return tipo_archivo;
	}

	public void setTipo_archivo(String tipo_archivo) {
		this.tipo_archivo = tipo_archivo;
	}

	
	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public String getStatususer() {
		return statususer;
	}

	public void setStatususer(String statususer) {
		this.statususer = statususer;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public long getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(long idmensaje) {
		this.idmensaje = idmensaje;
	}

	public long getId_chat() {
		return id_chat;
	}

	public void setId_chat(long id_chat) {
		this.id_chat = id_chat;
	}

	@Column(name="foto_usuario", nullable = false)
	private String fotoperfil;

	public String getFotoperfil() {
		return fotoperfil;
	}

	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public String getMensaje_archivo() {
		return mensaje_archivo;
	}

	public void setMensaje_archivo(String mensaje_archivo) {
		this.mensaje_archivo = mensaje_archivo;
	}

	public Boolean getEncriptado() {
		return encriptado;
	}

	public void setEncriptado(Boolean encriptado) {
		this.encriptado = encriptado;
	}

	public Timestamp getFecha_enviado() {
		return fecha_enviado;
	}

	public void setFecha_enviado(Timestamp fecha_enviado) {
		this.fecha_enviado = fecha_enviado;
	}

	
}
