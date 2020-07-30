package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
	@Autowired
	ResourceLoader resourceLoader;


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

	@Override
	public String deleteExam(String examId) {

		return examDAL.deleteExam(examId);
	}

	@Override
	public String getExamPDF(String examId) {
		Resource resource = resourceLoader.getResource("classpath:QuestionPaper.html");
		Exam exam=examDAL.getExam(examId);
		String content =null;
		try {
			InputStream input = resource.getInputStream();
			File file = resource.getFile();
			 content = new String(Files.readAllBytes(file.toPath()));
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}


}
