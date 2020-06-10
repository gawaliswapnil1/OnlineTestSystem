package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Exam;
import com.example.demo.model.ExamTemplate;
import com.example.demo.model.Question;
import com.example.demo.repository.ExamDAL;

@Service
public class ExamServiceImpl implements ExamService {

	
	@Autowired
	private ExamDAL examDAL;
	@Autowired 
	ExamTemplateService examTemplateService;
	@Autowired
	QuestionService questionService;
	
	
	@Override
	public String createExam(Exam exam) {
		ExamTemplate examTemplate=new ExamTemplate();
		int hardQuestions,easyQuestions,mediumQuestions;
		
		//get template to based on templateID
		examTemplate=examTemplateService.getExamTemplate(exam.getExamtemplateid());
		hardQuestions=examTemplate.getHardques();
		easyQuestions=examTemplate.getEasyques();
		mediumQuestions=examTemplate.getMediumques();
		
		//set exam attribute name,category
		exam.setExamname(examTemplate.getTemplatename()+"_"+exam.getUserid());
		exam.setCategory(examTemplate.getCategory());
		exam.setOutofmarks(examTemplate.getTotalmarks());
		//get questions based on template level
		List<Question> examQuestion=new ArrayList<Question>();
		List<Question> hardQuestionList = questionService.getQuestionBasedOnLevel("hard");
		List<Question> mediumQuestionList = questionService.getQuestionBasedOnLevel("medium");
		List<Question> easyQuestionList = questionService.getQuestionBasedOnLevel("easy");
		
		examQuestion.addAll(generateRandomQuestion(hardQuestionList,hardQuestions));
		examQuestion.addAll(generateRandomQuestion(easyQuestionList,easyQuestions));
		examQuestion.addAll(generateRandomQuestion(mediumQuestionList,mediumQuestions));
		
		exam.setQuestions(examQuestion);
		
		return examDAL.createExam(exam);
		
	}

	private static List<Question> generateRandomQuestion(List<Question> Questions,int number) 
	{
		List<Question> questionSet=new ArrayList<Question>();
		for(int i=0;i<number;i++)
		{
			Random rand = new Random(); 
			questionSet.add(Questions.get(rand.nextInt(Questions.size()))); 
			
		}
		return questionSet;
	}
	@Override
	public Exam getExam(String examId) {
		
		return examDAL.getExam(examId);
	}

	
}
