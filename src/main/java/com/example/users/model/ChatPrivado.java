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
@Table(name="ChatPrivados")
public class ChatPrivado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idchat;
	
	
	@Column(name="lastmessage", nullable = true)
	private String ultimo_mensaje;
	
	@Column (name="id_destinatario", nullable = true)
	private long iddestinatario;
	
	@Column (name="id_remitente", nullable = true)
	private long idremitente;
	
	
	public long getIdremitente() {
		return idremitente;
	}

	public void setIdremitente(long idremitente) {
		this.idremitente = idremitente;
	}

	public long getIddestinatario() {
		return iddestinatario;
	}

	public void setIddestinatario(long iddestinatario) {
		this.iddestinatario = iddestinatario;
	}

	public long getIdchat() {
		return idchat;
	}

	public void setIdchat(long idchat) {
		this.idchat = idchat;
	}


	public String getUltimo_mensaje() {
		return ultimo_mensaje;
	}

	public void setUltimo_mensaje(String ultimo_mensaje) {
		this.ultimo_mensaje = ultimo_mensaje;
	}

	

}
