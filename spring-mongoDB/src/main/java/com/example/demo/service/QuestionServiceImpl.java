package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.QuestionReporitory;

public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionReporitory repository;

	public String saveQuestion(Question que)
	{
		
		repository.save(que);
		return "Added Question Successfully "+que.getId();
	}


	public List<Question> getQuestions() 
	{
		return repository.findAll();
	}


	public Optional<Question> getQuestion(String id)
	{
		return repository.findById(id);
	}

	public String deletebyId(String id)
	{
		repository.deleteById(id);
		return "Question deleted successfully";
	}
}
