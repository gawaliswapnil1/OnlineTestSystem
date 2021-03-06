package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDAL;



@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAL userdal;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addNewUser(User user) {

		user.setpassword(passwordEncoder.encode(user.getpassword()));
		userdal.addNewUser(user);
		return "Added User with ID: "+user.getId();	}

	@Override
	public List<User> findAll() {

		return userdal.findAllUsers();
	}

	@Override
	public String validateUser(User user) {
		
		return userdal.validateUser(user);
	}



	public String signUpUser(User user) {
		user.setpassword(passwordEncoder.encode(user.getpassword()));
		return userdal.signUpUser(user); }




}
