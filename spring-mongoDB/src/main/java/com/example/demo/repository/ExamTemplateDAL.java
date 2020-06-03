package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.ExamTemplate;



public interface ExamTemplateDAL {

	public String createExamTemplate(ExamTemplate examTemplate);
	public List<ExamTemplate> getExamTemplates();
	ExamTemplate getExamTemplate(String id);
	String deletebyId(String id);
	boolean checkTemplateExists(String name);
}
