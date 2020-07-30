package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.demo.model.Exam;
import com.example.demo.model.ExamTemplate;
import com.example.demo.model.Question;
import com.example.demo.repository.ExamDAL;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

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

		Exam exam=examDAL.getExam(examId);
		String qPaper =null;
		if(exam!=null )
		{

			try {
				qPaper=getResourceFile("QuestionPaper.html");
				String singleQuestion=getResourceFile("Question.html");

				StringBuilder wholeQuestion=new StringBuilder();
				List<Question> questions=exam.getQuestions();
				for(int i=0;i<questions.size();i++)
				{
					String contentQuestion=singleQuestion;
					contentQuestion=contentQuestion.replace("@Question",(i+1)+".  "+questions.get(i).getQuestion());
					ArrayList options=questions.get(i).getChoices();
					StringBuilder contentOption=new StringBuilder();
					for(int j=0;j<options.size();j++)
					{
						Map<String, String> hMap	=(Map) options.get(j);				
						for ( String key : hMap.keySet()) {
							contentOption.append(key +"."+hMap.get(key)+"</br>");
						}
					}
					contentQuestion=contentQuestion.replace("@option", contentOption);
					wholeQuestion.append(contentQuestion);
				}
				qPaper=qPaper.replace("@MainSection", wholeQuestion);
				String path = "C:\\tmp\\input.txt";
				Files.write( Paths.get(path), qPaper.getBytes());
				//create PDF from 	
				File htmlSource = new File("C:\\tmp\\input.txt");
				File pdfDest = new File("D:\\QuesrionPaper.pdf");
				// pdfHTML specific code
				ConverterProperties converterProperties = new ConverterProperties();
				HtmlConverter.convertToPdf(new FileInputStream(htmlSource),  new FileOutputStream(pdfDest), converterProperties);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "file created at D:\\QuestionPaper.pdf";
	}

	private String getResourceFile(String fileName) throws IOException
	{
		Resource resource = resourceLoader.getResource("classpath:"+fileName);
		InputStream input = resource.getInputStream();
		File file = resource.getFile();
		String content = new String(Files.readAllBytes(file.toPath()));
		return content;
	}



}
