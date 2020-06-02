package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionDAL;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAL queDal;
	
	public String saveQuestion(Question que)
	{
		return queDal.saveQuestion(que);
	}


	public List<Question> getQuestions() 
	{
		return queDal.getQuestions();
	}


	public Question getQuestion(String id)
	{
		return queDal.getQuestion(id);
	}

	public String deletebyId(String id)
	{
		return queDal.deletebyId(id);
		
	}
}
