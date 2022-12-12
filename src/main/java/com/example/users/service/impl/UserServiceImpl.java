package com.example.users.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;
import com.example.users.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public User saveUser (User user) {
		return userRepo.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}


	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		Optional<User> usuario = userRepo.findByEmailAndPassword(email,password);
	if(usuario.isPresent()) {
		return usuario.get();
	}else {
		return null;
	}
	}


	@Override
	public User getUserByEmail(String email) {
		Optional<User> usuario = userRepo.findByEmail(email);
		System.out.print(usuario);
		if(usuario.isPresent()) {
			return usuario.get();
		}else {
			throw new ResourceNotFoundException("Usuario","email",email);
		}
		
	}
	
	public User GetUserById(Long id) {
		Optional<User> usuario = userRepo.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		}else {
			throw new ResourceNotFoundException("Usuario","email",id);
		}
		
	}


	@Override
	public List<User> getOnlineUsers() {
		List<User> usuarios = userRepo.findByOnline();
		return usuarios;
	}


	@Override
	public int updateUserStatus(Long id, String status) {
		 userRepo.UpdateStatusUserById(id, status);
		 return 1;
		
	}




	
}
