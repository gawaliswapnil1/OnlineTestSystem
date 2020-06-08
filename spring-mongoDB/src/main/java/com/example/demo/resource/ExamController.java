package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Exam;
import com.example.demo.service.ExamService;

@RestController
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@PostMapping("/createExam")
	public String createExam(@RequestBody Exam exam)
	{
		return examService.createExam(exam);
	}
	
	@GetMapping("/getExam/{id}")
	public Exam getExam(@PathVariable String examId)
	{
		return examService.getExam(examId);
	}
	

}
