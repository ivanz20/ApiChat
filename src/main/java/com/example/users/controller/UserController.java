package com.example.users.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.users.model.User;

import com.example.users.service.UserService;

@RestController

@CrossOrigin(origins= "*")

@RequestMapping("/api/users")
public class UserController {
	
	private	UserService userservice;

	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	//build create users REST API
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping()
	public ResponseEntity<User> saveUser( @RequestBody User usuario){
		return new ResponseEntity<User>(userservice.saveUser(usuario),HttpStatus.CREATED);
		
	}
	
	//get all Users,
	
	@GetMapping("/all")
	public List<User> gettAllUsers(){
		return userservice.getAllUsers();
	}
	
	
	@GetMapping("/UsersOnline")
	public List<User> getOnlineUsers(){
		return userservice.getOnlineUsers();
	}
	
	
	@GetMapping("/userid/{id}")
	public User getUserById(@PathVariable Long id){
		return userservice.GetUserById(id);
	}
	
	
	@GetMapping("/userUpdate/")
	@ResponseBody
	public  int UpdateStatus(@RequestParam(name = "id") Long id, @RequestParam(name = "status") String status) {
		  userservice.updateUserStatus(id, status);
		  return 1;
	}
	

//	get login validation
	@PostMapping("/emailValidacion")
	public ResponseEntity<User> getUserByEmail(@RequestBody User usuario){
		return new ResponseEntity<User>(userservice.getUserByEmail(usuario.getEmail()),HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public User login(@RequestBody User usuario) {
		User oauthUser = userservice.getUserByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			oauthUser.setStatus("online");
			userservice.saveUser(oauthUser);
			return oauthUser;
		}else {
			return null;
		}
	}
	
}
