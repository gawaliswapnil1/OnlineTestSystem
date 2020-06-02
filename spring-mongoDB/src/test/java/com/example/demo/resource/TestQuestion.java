package com.example.demo.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.model.Question;


@SpringBootTest
public class TestQuestion {
	@Autowired
	QuestionController questionController;
	@Autowired
	Question question;
	
	
	@Test
	void testGetQuestion() {		
		Assert.noNullElements((questionController.getQuestions()),"Got All Questionss");
	}
	
	@Test
	void testCreateQuestion() throws JSONException
	{
		Question que=createDummyQuestionForInsertion();
		
		assertEquals(questionController.saveQuestion(que),"Question Added successfully "+que.getId());
		
		
	}
	
	private static Question createDummyQuestionForInsertion() throws JSONException
	{
		Question que=new Question();
		ArrayList ans=new ArrayList();
		JSONObject obj = new JSONObject();
		obj.put("c:", "foo");
		ans.add(obj.toString());
		ObjectId id=new ObjectId();
	
		que.setId("1");
		que.setQuestion("What is Java");
       que.setActive(true);
       que.setLanguage("TestLanguage");
       que.setType("MCQ");
       que.setWeightage(5);
       que.setAnswer(ans);;
       return que;
		
	}
}
