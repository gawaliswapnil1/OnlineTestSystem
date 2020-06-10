package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Question;


public interface QuestionDAL {
	
	public String saveQuestion(Question que);
	public List<Question> getQuestions();
	public Question getQuestion( String id);
	public String deletebyId(String id);
	public List<Question> getQuestionBasedOnLevel(String level);
}
