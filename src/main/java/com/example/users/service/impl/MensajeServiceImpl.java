package com.example.users.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.users.model.Mensajes;
import com.example.users.repository.MessageRepository;
import com.example.users.service.MensajeService;
@Service
public class MensajeServiceImpl implements MensajeService{

	private MessageRepository mesarepo;

	public MensajeServiceImpl(MessageRepository mesarepo) {
		super();
		this.mesarepo = mesarepo;
	}
	
	public Mensajes SaveMensaje (Mensajes mensaje) {
		return mesarepo.save(mensaje);
	}

	@Override
	public List<Mensajes> gettAllMensajes() {
		return mesarepo.findAll();
	}
	

}
