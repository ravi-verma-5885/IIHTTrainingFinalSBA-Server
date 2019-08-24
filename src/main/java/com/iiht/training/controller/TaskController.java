package com.iiht.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.model.Task;
import com.iiht.training.service.IProjectService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable("taskId") Long taskId) {
		ResponseEntity<Task> response = null;

		Task task = projectService.getTaskById(taskId);

		if (null != task) {
			response = new ResponseEntity<Task>(task, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> taskList = projectService.listTasks();
		return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		Task taskReturned = projectService.addTask(task);
		return new ResponseEntity<Task>(taskReturned, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task taskReturned = projectService.addTask(task);
		return new ResponseEntity<Task>(taskReturned, HttpStatus.OK);

	}

	@DeleteMapping("/{taskId}")
	public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long taskId) {

		ResponseEntity<Void> response = null;
		Task task = projectService.getTaskById(taskId);

		if (null != task) {
			projectService.deleteTask(taskId);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

}