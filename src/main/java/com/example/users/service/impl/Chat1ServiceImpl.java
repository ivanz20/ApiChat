package com.example.users.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.ChatPrivado;
import com.example.users.model.Mensajes;
import com.example.users.model.User;
import com.example.users.repository.Chat1Repository;
import com.example.users.repository.MessageRepository;
import com.example.users.service.Chat1Service;

@Component
public class Chat1ServiceImpl implements Chat1Service{
	Chat1Repository chatrepo;
//	
//
	public Chat1ServiceImpl(Chat1Repository chatrepo) {
		super();
		this.chatrepo = chatrepo;
	}
	@Override
	public List<ChatPrivado> getUserChats(Long id1) {
		List<ChatPrivado> chats = chatrepo.FindUserChatsById(id1);
		return chats;
	}
	@Override
	public ChatPrivado saveChat(ChatPrivado chat) {
		return chatrepo.save(chat);

	}
	

	
}
