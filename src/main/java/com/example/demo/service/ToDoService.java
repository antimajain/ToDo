package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	ToDoRepository repo;

	public ToDo addToDoTask(ToDo toDoTask) {
		return repo.save(toDoTask);
	}

	public List<ToDo> getAllToDoUnArchive() {
		List<ToDo> list1=repo.findByArchiveAndCompleted(false,false);
		List<ToDo> list2=repo.findByArchiveAndCompleted(false,true);
		 list1.addAll(list2);
		 return list1;
	}

	public String deleteToDo(String id) {
		repo.deleteById(id);
		return "Successfully deleted";
	}

	public ToDo markAsDone(String id) {
		ToDo todo = repo.findById(id);
		todo.setCompleted(true);
		return repo.save(todo);

	}

	public ToDo archiveTask(String id) {
		ToDo todo = repo.findById(id);
		todo.setArchive(true);
		return repo.save(todo);
	}

	public ToDo retrieveTask(String id) {
		ToDo todo = repo.findById(id);
		todo.setArchive(false);
		return repo.save(todo);
	}

	public List<ToDo> getAllToDo() {
		return repo.findAll();
	}

}
