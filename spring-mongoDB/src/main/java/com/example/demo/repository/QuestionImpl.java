package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.example.demo.model.Question;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
@Component
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
		mongoTemplate.remove(mongoTemplate.findById(id, Question.class));
		return "Question Deleted successfully";
	}

	@Override
	public List<Question> getQuestionBasedOnLevel(String level) {
		//ArrayList<Question> listQuestion=new ArrayList<Question>();
		Query query = new Query();
		query.addCriteria(Criteria.where("level").is(level));
		List<Question> question = mongoTemplate.find(query, Question.class);
		
		return question;
	}

}
