package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.example.demo.model.Exam;

@Component
public class ExamImpl implements ExamDAL{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Exam getExam(String examId) {
		return mongoTemplate.findById(examId, Exam.class);
		
	}

	@Override
	public String createExam(Exam exam) {
		mongoTemplate.save(exam);
		return "Exam Created successfully "+exam.getExamid();
		
	}

	@Override
	public String deleteExam(String examId) {
		
		mongoTemplate.remove(mongoTemplate.findById(examId, Exam.class));
		return "Exam Deleted Successfully";
	}
	

}
