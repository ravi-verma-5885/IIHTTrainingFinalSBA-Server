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

import com.iiht.training.model.User;
import com.iiht.training.service.IProjectService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		ResponseEntity<User> response = null;

		User user = projectService.getUserById(userId);

		if (null != user) {
			response = new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			response = new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(projectService.listUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<List<User>> addUser(@RequestBody User user) {
		projectService.addUser(user);
		return new ResponseEntity<List<User>>(projectService.listUsers(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
		projectService.addUser(user);
		return new ResponseEntity<List<User>>(projectService.listUsers(), HttpStatus.OK);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {

		ResponseEntity<Void> response = null;
		User user = projectService.getUserById(userId);

		if (null != user) {
			projectService.deleteUser(userId);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

}
