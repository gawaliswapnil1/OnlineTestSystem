package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Question;

public interface QuestionService {
	
	public String saveQuestion(Question que);
	public List<Question> getQuestions();
	public Optional<Question> getQuestion( String id);
	public String deletebyId(String id);
	

}
