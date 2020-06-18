package com.example.demo.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

import com.example.demo.model.Exam;

@SpringBootTest
public class TestExam {

	@Autowired
	ExamController examController;
	@Autowired 
	MongoTemplate mongoTemplate;
	
	Exam exam=null;;
	
	@BeforeEach
	void initExam()
	{
		
		exam=createDummyExamData();
	}
	
	@AfterEach
	 void tearOff() 
	{
		examController.deleteExam(exam.getExamid());
	}
	@Test
	void getExam()
	{
		examController.createExam(exam);
		Exam examTest=examController.getExam(exam.getExamid());
		assertNotNull(examTest,"Exam Found");
	
	}
	@Test
	void createExam()
	{

		assertEquals(examController.createExam(exam),"Exam Created successfully "+exam.getExamid());
		
	}
	
	
	private  Exam createDummyExamData() 
	{
		Exam exam=new Exam();
		exam.setExamid("1");
		exam.setExamtemplateid("5edf3551eee4fb5d67b5a29b");
		exam.setUserid("5edf3551eee4fb5d67b5a29b");
		return exam;
	}
}
