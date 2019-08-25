package com.iiht.training.service;

import java.util.List;

import com.iiht.training.model.ParentTask;
import com.iiht.training.model.Project;
import com.iiht.training.model.Task;
import com.iiht.training.model.User;

public interface IProjectService {
	
	public User getUserById(Long userId);
	
	public List<User> listUsers(); 
	
	public User addUser(User user);
	
	public void deleteUser(Long userId);
	
	public Project getProjectById(Long projectId);
	
	public List<Project> listProjects(); 
	
	public Project addProject(Project project);
	
	public void deleteProject(Long projectId);
	
	public Task getTaskById(Long taskId);
	
	public List<Task> listTasks(); 
	
	public Task addTask(Task task);
	
	public Task updateTaskForStatus(Task task);
	
	public void deleteTask(Long taskId);
	
	public ParentTask getParentTaskById(Long parentTaskId);
	
	public List<ParentTask> listParentTasks(); 
	
	public ParentTask addParentTask(ParentTask parentTask);
	
}
