package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	String addNewUser(User user);
	List<User> findAll();
	String validateUser(User user);
	String signUpUser(User user);
	
}
