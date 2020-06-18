package com.example.demo.repository;

import com.example.demo.model.Exam;

public interface ExamDAL {

	public Exam getExam( String examId);
	public String createExam(Exam exam);
	public String deleteExam(String examId);
}
