package com.iiht.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.model.ParentTask;
import com.iiht.training.service.IProjectService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/parentTasks")
public class ParentTaskController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/{parentTaskId}")
	public ResponseEntity<ParentTask> getParentTaskById(@PathVariable("parentTaskId") Long parentTaskId) {
		ResponseEntity<ParentTask> response = null;

		ParentTask parentTask = projectService.getParentTaskById(parentTaskId);

		if (null != parentTask) {
			response = new ResponseEntity<ParentTask>(parentTask, HttpStatus.OK);
		} else {
			response = new ResponseEntity<ParentTask>(parentTask, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<ParentTask>> getAllParentTasks() {
		List<ParentTask> parentTaskList = projectService.listParentTasks();
		return new ResponseEntity<List<ParentTask>>(parentTaskList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ParentTask> addParentTask(@RequestBody ParentTask parentTask) {
		ParentTask parentTaskReturned = projectService.addParentTask(parentTask);
		return new ResponseEntity<ParentTask>(parentTaskReturned, HttpStatus.OK);
	}
	

}
