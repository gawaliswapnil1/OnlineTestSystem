package com.example.demo.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.ExamTemplate;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@Component
public class ExamTemplateImpl implements ExamTemplateDAL {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String createExamTemplate(ExamTemplate examTemplate) {
		mongoTemplate.save(examTemplate);
		return "Template Saved Successfully "+examTemplate.getId();
	}

	@Override
	public List<ExamTemplate> getExamTemplates() {
		return mongoTemplate.findAll(ExamTemplate.class);
		
	}
	
	@Override
	public ExamTemplate getExamTemplate(String id) {
	return	mongoTemplate.findById(id, ExamTemplate.class);
	
	}

	@Override
	public String deletebyId(String id) {
		mongoTemplate.remove(id);
		return "ExamTemplate Deleted successfully";
	}

	@Override
	public boolean checkTemplateExists(String name) {
		MongoCollection<Document> collection=mongoTemplate.getCollection("ExamTemplate");
		boolean result=false;
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name",name);
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();  

		try 
		{
			if (cursor.hasNext()) 
			{
				result=true;
			}
		} finally {
			cursor.close();
		}	
		return result;	
	}

}
