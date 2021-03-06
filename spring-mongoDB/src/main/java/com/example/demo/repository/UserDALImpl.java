package com.example.demo.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Component
public class UserDALImpl implements UserDAL{

	//Get the properties value from application.properties

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addNewUser(User user) {
		
		mongoTemplate.save(user);
		return "User Added Successfully";
	}

	@Override
	public List<User> findAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public String validateUser(User user) 
	{
		
		MongoCollection<Document> collection=mongoTemplate.getCollection("User");
		String result="Please check userName or password";
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name",user.getName());
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();  

		try 
		{
			while (cursor.hasNext()) 
			{
				Document dbDocument=cursor.next();
				if(passwordEncoder.matches(user.getpassword(), dbDocument.getString("password")))
					return dbDocument.getString("role");
			}
		} finally {
			cursor.close();
		}	
		return result;	
	}


	@Override public String signUpUser(User user) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(user.getName()));
		List<User> userFound = mongoTemplate.find(query, User.class);
		if(!userFound.isEmpty())
		 return "UserName already exists please use another username";
		else
		{
			mongoTemplate.save(user);
			return "Account created successfully!!";
		}

	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	@Override
	public List<User> findAllCandidate() {
		  
		Query query = new Query();
		query.addCriteria(Criteria.where("role").is("user"));
		List<User> users = mongoTemplate.find(query, User.class);
		return users;	
	}
}
