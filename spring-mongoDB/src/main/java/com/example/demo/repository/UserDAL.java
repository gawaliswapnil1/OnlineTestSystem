package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

public interface UserDAL {

	
	String addNewUser(User user);
	List<User> findAllUsers();
	String validateUser(User user);
	String signUpUser(User user);
	List<User> findAllCandidate();
}
