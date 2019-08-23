package com.iiht.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.training.dao.IProjectRepository;
import com.iiht.training.dao.ITaskRepository;
import com.iiht.training.dao.IUserRepository;
import com.iiht.training.model.Project;
import com.iiht.training.model.Task;
import com.iiht.training.model.User;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IProjectRepository projectRepo;
	
	@Autowired
	private ITaskRepository taskRepo;

	@Override
	public User getUserById(Long userId) {
		Optional<User> optUser = userRepo.findById(userId);
		User user = optUser.isPresent() ? optUser.get() : null;

		return user;
	}

	@Override
	public List<User> listUsers() {
		return userRepo.findAll();
	}

	@Transactional
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Transactional
	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}
	
	@Override
	public Project getProjectById(Long projectId) {
		Optional<Project> optProject = projectRepo.findById(projectId);
		Project project = optProject.isPresent() ? optProject.get() : null;

		return project;
	}

	@Override
	public List<Project> listProjects() {
		return projectRepo.findAll();
	}

	@Transactional
	@Override
	public Project addProject(Project project) {
		Project projectReturned = projectRepo.save(project);
		return projectReturned;
	}

	@Transactional
	@Override
	public void deleteProject(Long projectId) {
		projectRepo.deleteById(projectId);
	}
	
	@Override
	public Task getTaskById(Long taskId) {
		Optional<Task> optTask = taskRepo.findById(taskId);
		Task task = optTask.isPresent() ? optTask.get() : null;

		return task;
	}

	@Override
	public List<Task> listTasks() {
		return taskRepo.findAll();
	}

	@Transactional
	@Override
	public Task addTask(Task task) {
		Task taskReturned = taskRepo.save(task);
		return taskReturned;
	}

	@Transactional
	@Override
	public void deleteTask(Long taskId) {
		taskRepo.deleteById(taskId);
	}

}
