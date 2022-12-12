package com.example.users.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.ChatPrivado;
import com.example.users.model.Mensajes;
import com.example.users.model.MensajesLista;
import com.example.users.model.User;
import com.example.users.repository.Chat1Repository;
import com.example.users.repository.MessageRepository;
import com.example.users.repository.UserRepository;
import com.example.users.service.Chat1Service;
import com.example.users.service.UserService;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/api/chatsprivados")
public class PrivateChatsController {

	private Chat1Repository chat1repo;
	private UserRepository UserRepo;
	private MessageRepository mesarepo;
	
	private Chat1Service chatService;
	
	public PrivateChatsController(Chat1Repository chat1repo,UserRepository UserRepo,MessageRepository mesarepo,Chat1Service chatService) {
		super();
		this.chat1repo = chat1repo;
		this.UserRepo = UserRepo;
		this.mesarepo = mesarepo;
		this.chatService =  chatService;
	}

	

	@GetMapping("/UserChats/{id1}")
	@ResponseBody
	public List<MensajesLista> getUserChats(@PathVariable Long id1){
		List<ChatPrivado> chatsdeusuario = chat1repo.FindUserChatsById(id1);
		List<MensajesLista> MensajesDeUsuario = new ArrayList<MensajesLista>();

		for (ChatPrivado chat : chatsdeusuario) {
			if(id1 == chat.getIddestinatario()) {
				User useraux = UserRepo.getById(chat.getIdremitente());
				MensajesLista mensajeauxliar = new MensajesLista();
				mensajeauxliar.setFotoperfil(useraux.getFotoperfil());
				mensajeauxliar.setStatus(useraux.getStatus());
				mensajeauxliar.setUsername(useraux.getUsername());
				mensajeauxliar.setUltimomensaje(chat.getUltimo_mensaje());
				mensajeauxliar.setIdusuario(chat.getIdremitente());
				
				MensajesDeUsuario.add(mensajeauxliar);
				
			}else {
				User useraux = UserRepo.getById(chat.getIddestinatario());
				MensajesLista mensajeauxliar = new MensajesLista();
				mensajeauxliar.setFotoperfil(useraux.getFotoperfil());
				mensajeauxliar.setStatus(useraux.getStatus());
				mensajeauxliar.setUsername(useraux.getUsername());
				mensajeauxliar.setUltimomensaje(chat.getUltimo_mensaje());
				mensajeauxliar.setIdusuario(chat.getIddestinatario());
				
				MensajesDeUsuario.add(mensajeauxliar);

			}
		}
		
		
		return MensajesDeUsuario;
	}
	
	
	@GetMapping("/getusermensajes")
		private List<Mensajes> loadMensajes() {
		List<Mensajes> auxmsn = mesarepo.GetOneOnOneMsn();
		return auxmsn;
	}
	
	
	@PostMapping("/addchat")
	@ResponseBody
	private ResponseEntity<ChatPrivado> AddChaat(@RequestBody ChatPrivado chat) {
		return new ResponseEntity<ChatPrivado>(chatService.saveChat(chat),HttpStatus.CREATED);

	}
	
	

}
