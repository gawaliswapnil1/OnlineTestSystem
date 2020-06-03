package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody User user)
	{
		return userService.addNewUser(user);
		
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

	@PostMapping("/signUpUser") public String signUpUser(@RequestBody User user)
	{ 
		return userService.signUpUser(user);

	}



}
