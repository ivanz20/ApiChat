package com.example.users.service;

import java.util.List;

import com.example.users.model.Mensajes;
import com.example.users.model.User;

public interface MensajeService {

	Mensajes SaveMensaje(Mensajes mensaje);
	List<Mensajes> gettAllMensajes();
	
}
