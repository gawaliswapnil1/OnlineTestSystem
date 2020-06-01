package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Question;

public interface QuestionDAL {
	
	public String saveQuestion(Question que);
	public List<Question> getQuestions();
	public Question getQuestion( String id);
	public String deletebyId(String id);
}
