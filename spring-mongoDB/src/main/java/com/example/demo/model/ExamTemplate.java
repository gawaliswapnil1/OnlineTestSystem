package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="ExamTemplate")
@Component
public class ExamTemplate {

	@Id
	private String  id;
	private String templatename;
	private String category;
	private String level;
	private int hardques;
	private int mediumques;
	private int easyques;
	private int totalmarks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTemplatename() {
		return templatename;
	}
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getHardques() {
		return hardques;
	}
	public void setHardques(int hardques) {
		this.hardques = hardques;
	}
	public int getMediumques() {
		return mediumques;
	}
	public void setMediumques(int mediumques) {
		this.mediumques = mediumques;
	}
	public int getEasyques() {
		return easyques;
	}
	public void setEasyques(int easyques) {
		this.easyques = easyques;
	}
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	@Override
	public String toString() {
		return "ExamTemplate [id=" + id + ", templatename=" + templatename + ", category=" + category + ", level="
				+ level + ", hardques=" + hardques + ", mediumques=" + mediumques + ", easyques=" + easyques
				+ ", totalmarks=" + totalmarks + "]";
	}
	
}
