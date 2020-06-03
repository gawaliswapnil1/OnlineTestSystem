package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ExamTemplate;

public interface ExamTemplateService {

	public String createExamTemplate(ExamTemplate examTemplate);
	public List<ExamTemplate> getExamTemplates();
	ExamTemplate getExamTemplate(String id);
	String deletebyId(String id);
	
}
