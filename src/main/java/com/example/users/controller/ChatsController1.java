package com.example.users.controller;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.users.model.ChatPrivado;
import com.example.users.model.Mensajes;
import com.example.users.model.MensajesLista;
import com.example.users.model.User;
import com.example.users.repository.Chat1Repository;
import com.example.users.repository.MessageRepository;
import com.example.users.repository.UserRepository;
import com.example.users.service.UserService;

@RestController

@CrossOrigin(origins= "*")


public class ChatsController1 {
	private MessageRepository mesarepo;
	
	private Chat1Repository chatRepo;
	
	private UserRepository userrepo;


	
	public ChatsController1(MessageRepository mesarepo, UserRepository userrepo) {
		super();
		this.mesarepo = mesarepo;
		this.userrepo = userrepo;

	}


	@Autowired
	private SimpMessagingTemplate simpMessaginTemplate;
	
	@MessageMapping("/message")
	@SendTo("/chatroom/public")
	public Mensajes receivePublicMessage(@Payload Mensajes mensaje) {
		if(mensaje.getMessage()!= null) {
			if(mensaje.getEncriptado()) {
				String encodeBytes = Base64.getEncoder().encodeToString((mensaje.getMessage()).getBytes());
				mensaje.setMessage(encodeBytes);
				mesarepo.save(mensaje);
			}else {
				mesarepo.save(mensaje);
			}
		}
		
		return mensaje;
	}
	
	
	@MessageMapping("/private-message")
	private Mensajes receivePrivateMessage(@Payload Mensajes mensaje) {
		
		if(mensaje.getEncriptado()) {
			String encodeBytes = Base64.getEncoder().encodeToString((mensaje.getMessage()).getBytes());
			mensaje.setMessage(encodeBytes);
			mesarepo.save(mensaje);
		}else {
			mesarepo.save(mensaje);
		}
		
		simpMessaginTemplate.convertAndSendToUser(mensaje.getReceiver_name(),"/private",mensaje);
		return mensaje;
	}
	
	

//	@MessageMapping("/UserChats/{id1}")
//	@ResponseBody
//	public List<MensajesLista> getUserChats(@PathVariable Long id1){
//		List<ChatPrivado> chatsdeusuario = chatRepo.FindUserChatsById(id1);
//		List<MensajesLista> MensajesDeUsuario = new ArrayList<MensajesLista>();
//
//		for (ChatPrivado chat : chatsdeusuario) {
//			if(id1 == chat.getIddestinatario()) {
//				User useraux = userrepo.getById(chat.getIdremitente());
//				MensajesLista mensajeauxliar = new MensajesLista();
//				mensajeauxliar.setFotoperfil(useraux.getFotoperfil());
//				mensajeauxliar.setStatus(useraux.getStatus());
//				mensajeauxliar.setUsername(useraux.getUsername());
//				mensajeauxliar.setUltimomensaje(chat.getUltimo_mensaje());
//				mensajeauxliar.setIdusuario(chat.getIdremitente());
//				
//				MensajesDeUsuario.add(mensajeauxliar);
//				
//			}else {
//				User useraux = userrepo.getById(chat.getIddestinatario());
//				MensajesLista mensajeauxliar = new MensajesLista();
//				mensajeauxliar.setFotoperfil(useraux.getFotoperfil());
//				mensajeauxliar.setStatus(useraux.getStatus());
//				mensajeauxliar.setUsername(useraux.getUsername());
//				mensajeauxliar.setUltimomensaje(chat.getUltimo_mensaje());
//				mensajeauxliar.setIdusuario(chat.getIddestinatario());
//				
//				MensajesDeUsuario.add(mensajeauxliar);
//
//			}
//		}
//		
////		
////		return MensajesDeUsuario;
////	}
	


	


	
}
