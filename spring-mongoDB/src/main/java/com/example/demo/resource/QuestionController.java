package com.example.demo.resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/addQuestion")
	public String saveQuestion(@RequestBody Question que)
	{
		return questionService.saveQuestion(que);
		
	}
	
	@GetMapping("/findAllQuestion")
	public List<Question> getQuestions() 
	{
		return questionService.getQuestions();
	}
	
	@GetMapping("/findAllQuestion/{id}")
	public Question getQuestion(@PathVariable String id)
	{
		return questionService.getQuestion(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletebyId(@PathVariable String id)
	{
		return questionService.deletebyId(id);
		
	}
}
