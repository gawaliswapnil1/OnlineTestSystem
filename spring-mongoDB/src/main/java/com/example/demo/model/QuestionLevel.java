package com.example.demo.model;

public enum QuestionLevel {

	Hard("5"),
	Easy("3"),
	Medium("1");

	 private String level;
	 
	 private String getLevel()
	 {
		 return this.level;
	 }
	QuestionLevel(String level) {
		this.level=level;
	}
}
