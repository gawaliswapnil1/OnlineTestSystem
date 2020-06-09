package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Question;
import com.example.demo.model.QuestionLevel;

public interface QuestionService {
	
	public String saveQuestion(Question que);
	public List<Question> getQuestions();
	public Question getQuestion( String id);
	public String deletebyId(String id);
	public List<Question> getQuestionBasedOnLevel(String level);
	

}
