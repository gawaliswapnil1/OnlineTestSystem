package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="Exam")
@Component
public class Exam {
	
	@Id
	private String examid;
	private String examname;
	private String category;
	private int outofmarks;
	private String userid;
	private String examtemplateid;
	private List<Question> questions;
	
	
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOutofmarks() {
		return outofmarks;
	}
	public void setOutofmarks(int outofmarks) {
		this.outofmarks = outofmarks;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getExamtemplateid() {
		return examtemplateid;
	}
	public void setExamtemplateid(String examtemplateid) {
		this.examtemplateid = examtemplateid;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	

}
