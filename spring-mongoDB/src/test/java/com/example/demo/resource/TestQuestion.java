package com.example.demo.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.model.Question;


@SpringBootTest
public class TestQuestion {
	@Autowired
	QuestionController questionController;
	@Autowired
	Question question;
	
	
	@Test
	void testGetQuestion() {
		
		Assert.noNullElements((questionController.getQuestions()),"Got All Questionss");
	}
}
