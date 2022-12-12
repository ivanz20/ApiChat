package com.example.users.service;

import java.util.List;
import java.util.Optional;

import com.example.users.model.User;

public interface UserService {
	User saveUser (User user);
	List<User> getAllUsers();
	User getUserByEmailAndPassword(String email, String password);
	User getUserByEmail(String email);
	User GetUserById(Long id);
	List<User> getOnlineUsers();
	int updateUserStatus(Long id, String status);

}
