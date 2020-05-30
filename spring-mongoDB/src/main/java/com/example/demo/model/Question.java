package com.example.demo.model;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection="QuestionTest")
@Component
public class Question {
	
	@Id
	private String  id;
	private String language;
	private int weightage;
	private String type;
	private String question;
	private ArrayList choices;
	private ArrayList answer;
	private boolean active;
	private boolean reviewed;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList getChoices() {
		return choices;
	}
	public void setChoices(ArrayList choices) {
		this.choices = choices;
	}
	public ArrayList getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList answer) {
		this.answer = answer;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isReviewed() {
		return reviewed;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
