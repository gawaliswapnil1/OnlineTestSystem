package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExamTemplate;
import com.example.demo.repository.ExamTemplateDAL;

@Service
public class ExamTemplateServiceImpl implements ExamTemplateService {

	@Autowired 
	private ExamTemplateDAL examTemplateDAL;

	@Override
	public String createExamTemplate(ExamTemplate examTemplate) {
		//check if template exists in system
		if(examTemplateDAL.checkTemplateExists(examTemplate.getTemplatename()))
			return "Template already exists in system"+examTemplate.getTemplatename();
		else
			return examTemplateDAL.createExamTemplate(examTemplate);
	}

	@Override
	public List<ExamTemplate> getExamTemplates() {
		return examTemplateDAL.getExamTemplates();
	}

	@Override
	public ExamTemplate getExamTemplate(String id) {
		return examTemplateDAL.getExamTemplate(id);	

	}

	@Override
	public String deletebyId(String id) {
		return examTemplateDAL.deletebyId(id);	}

}
