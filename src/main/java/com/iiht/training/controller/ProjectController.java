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

import com.iiht.training.model.Project;
import com.iiht.training.service.IProjectService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/{projectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable("projectId") Long projectId) {
		ResponseEntity<Project> response = null;

		Project project = projectService.getProjectById(projectId);

		if (null != project) {
			response = new ResponseEntity<Project>(project, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projectList = projectService.listProjects();
		return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		Project projectReturned = projectService.addProject(project);
		return new ResponseEntity<Project>(projectReturned, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		Project projectReturned = projectService.addProject(project);
		return new ResponseEntity<Project>(projectReturned, HttpStatus.OK);

	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Long projectId) {

		ResponseEntity<Void> response = null;
		Project project = projectService.getProjectById(projectId);

		if (null != project) {
			projectService.deleteProject(projectId);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

}
