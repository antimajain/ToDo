package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ToDo;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, ToDo> {

	void deleteById(String id);

	ToDo findById(String id);

	List<ToDo> findByArchiveAndCompleted(boolean b, boolean c);

}
