package com.example.demo.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.User;

@SpringBootTest
class TestUser {

	
	@Autowired
	UserController userController;
	@Autowired
	User user;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void testValidateCredential()
	{
		String username="Swapnil";
		String	passwrd="Swapnil123";

		user.setName(username);
		user.setpassword(passwrd);
		assertEquals("admin", userController.validateUser(user),"User credentials are validated");	
		
	}
	
	@Test
	void testValidateCredentialNegative()
	{
		String username="swapnil";
		String	passwrd="swapnil324";

		user.setName(username);
		user.setpassword(passwrd);
		assertEquals("Please check userName or password", userController.validateUser(user),"User credentials are validated negative test");	
		
	}
	
	@Test
	void testSignUpCandidate()
	{
		String username="swapnil";
		String	passwrd="swapnil324";
		
	}
	
	

}
