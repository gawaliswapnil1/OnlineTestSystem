package com.example.demo.service;

import com.example.demo.model.Exam;

public interface ExamService {
	public String createExam( Exam exam);
	public Exam getExam( String examId);
	public String deleteExam(String examId);
	public String getExamPDF(String examId);
	

}
