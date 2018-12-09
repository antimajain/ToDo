package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;

@Controller
@RequestMapping("/toDoList")
public class ToDoController {
	@Autowired
	ToDoService service;

	// add to do
	@RequestMapping(value = "/addTodo")
	public String addTask() {
		return "home";
	}

	@RequestMapping(value = "/addToDo", method = RequestMethod.POST)
	public @ResponseBody ToDo addToDoTask(@RequestBody ToDo toDoTask) {
		return service.addToDoTask(toDoTask);
	}

	@RequestMapping(value = "/getAllToDoUnArchive", method = RequestMethod.GET)
	public @ResponseBody List<ToDo> getAllToDoUnArchive() {
		return service.getAllToDoUnArchive();
	}

	@RequestMapping(value = "/removeToDo/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteToDo(@PathVariable String id) {
		return service.deleteToDo(id);
	}

	@RequestMapping(value = "/markAsDone/{id}", method = RequestMethod.PUT)
	public @ResponseBody ToDo markAsDone(@PathVariable String id) {
		return service.markAsDone(id);
	}

	@RequestMapping(value = "/archive/{id}", method = RequestMethod.PUT)
	public @ResponseBody ToDo archiveTask(@PathVariable String id) {
		return service.archiveTask(id);
	}

	@RequestMapping(value = "/moveToTask/{id}", method = RequestMethod.PUT)
	public @ResponseBody ToDo retrieveTask(@PathVariable String id) {
		return service.retrieveTask(id);
	}

	@RequestMapping(value = "/AllToDo")
	public String getAll() {
		return "allTask";
	}

	@RequestMapping(value = "/getAllToDo", method = RequestMethod.GET)
	public @ResponseBody List<ToDo> getAllToDo() {
		return service.getAllToDo();
	}
}
