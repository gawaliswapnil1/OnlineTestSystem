package com.example.demo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.Question;

public class QuestionImpl implements QuestionDAL{

	

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String saveQuestion(Question que) {
		mongoTemplate.save(que);
		return "Question Added successfully "+que.getId();
	}

	@Override
	public List<Question> getQuestions() {
		return mongoTemplate.findAll(Question.class);
		
	}

	@Override
	public Question getQuestion(String id) {
	return	mongoTemplate.findById(id, Question.class);
	
	}

	@Override
	public String deletebyId(String id) {
		mongoTemplate.remove(id);
		return "Question Deleted successfully";
	}

}
