package com.example.users.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.users.model.ChatPrivado;
import com.example.users.model.MensajesLista;
import com.example.users.model.User;

public interface Chat1Service {
	
	ChatPrivado saveChat (ChatPrivado chat);

	List<ChatPrivado> getUserChats(Long id1);

	
//	ChatPrivado CreateChat (ChatPrivado chat);
//	Optional<ChatPrivado> findById(Long idusuario);
}
