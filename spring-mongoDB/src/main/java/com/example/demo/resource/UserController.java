package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.User;
import com.example.demo.repository.UserDAL;
import com.example.demo.repository.UserDALImpl;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.mongodb.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
		
	
	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody User user)
	{
		userService.addNewUser(user);
		return "Added User with ID: "+user.getId();
	}
	
	@GetMapping("/findAllUser")
	public List<User> getUsers() 
	{
		return userService.findAll();
	}
	
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestBody User user) 
	{
		return userService.validateUser(user);
		
	}
	
	@PostMapping("/signUpUser")
	public String signUpUser(@RequestBody User user) 
	{
		return userService.validateUser(user);
		
	}
	
}
