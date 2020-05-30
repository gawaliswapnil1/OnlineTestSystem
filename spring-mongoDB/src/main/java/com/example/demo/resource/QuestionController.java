package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionReporitory;

@RestController
public class QuestionController {

	@Autowired
	private QuestionReporitory repository;
	
	
	@PostMapping("/addQuestion")
	public String saveQuestion(@RequestBody Question que)
	{
		repository.save(que);
		return "Added Question Successfully "+que.getId();
	}
	
	@GetMapping("/findAllQuestion")
	public List<Question> getQuestions() 
	{
		return repository.findAll();
	}
	
	@GetMapping("/findAllQuestion/{id}")
	public Optional<Question> getQuestion(@PathVariable String id)
	{
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletebyId(@PathVariable String id)
	{
		repository.deleteById(id);
		return "Question deleted successfully";
	}
}
