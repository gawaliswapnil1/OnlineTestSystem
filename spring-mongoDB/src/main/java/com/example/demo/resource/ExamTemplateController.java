package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExamTemplate;
import com.example.demo.service.ExamTemplateService;

@RestController
public class ExamTemplateController {

	@Autowired
	private ExamTemplateService examTemplateService;
	
	@PostMapping("/addExamTemplate")
	public String createExamTemplate(@RequestBody ExamTemplate examTemplate) {
		return examTemplateService.createExamTemplate(examTemplate);
	}
	
	@GetMapping("/findAllExamTemplate")
	public List<ExamTemplate> getExamTemplates()
	{
		return examTemplateService.getExamTemplates();
	}
	
	@GetMapping("/findAllExamTemplate/{id}")
	ExamTemplate getExamTemplate(@PathVariable String id)
	{
		return examTemplateService.getExamTemplate(id);
	}
	
	@DeleteMapping("/deleteExamTemplate/{id}")
	String deletebyId(@PathVariable String id)
	{
		return examTemplateService.deletebyId(id);
	}

}
