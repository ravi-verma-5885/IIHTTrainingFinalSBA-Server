package com.iiht.training.service;

import java.util.List;

import com.iiht.training.model.User;

public interface IProjectService {
	
	public User getUserById(Long userId);
	
	public List<User> listUsers(); 
	
	public User addUser(User user);
	
	public void deleteUser(Long userId);
	
}
