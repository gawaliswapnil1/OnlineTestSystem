package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Exam;
import com.example.demo.repository.ExamDAL;

@Service
public class ExamServiceImpl implements ExamService {

	
	@Autowired
	private ExamDAL examDAL;
	
	@Override
	public String createExam(Exam exam) {
		
		return examDAL.createExam(exam);
	}

	@Override
	public Exam getExam(String examId) {
		
		return examDAL.getExam(examId);
	}

	
}
