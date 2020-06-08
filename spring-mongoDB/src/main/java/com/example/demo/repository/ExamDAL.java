package com.example.demo.repository;

import com.example.demo.model.Exam;

public interface ExamDAL {

	public String createExam( Exam exam);
	public Exam getExam( String examId);
}
