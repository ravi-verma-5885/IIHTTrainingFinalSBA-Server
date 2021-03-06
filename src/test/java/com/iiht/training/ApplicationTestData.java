package com.iiht.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.iiht.training.model.ParentTask;
import com.iiht.training.model.Project;
import com.iiht.training.model.Task;
import com.iiht.training.model.User;

public class ApplicationTestData {
	
	public static Project getProjectDataToRead() {
		Project project = new Project(1, "FSA work related changes in all screens.", dateFromString("08/31/2019")
				, dateFromString("11/26/2019"), 9, getUserDataToRead());
		return project;
	}
	
	public static Project getProjectDataToWrite() {
		Project project = new Project();
		project.setPriority(12);
		project.setProjectName("Update Fee processing changes.");
		project.setStartDate(dateFromString("08/31/2019"));
		project.setEndDate(dateFromString("10/12/2019"));
		project.setUser(getUserDataToRead());
		
		return project;
	}
	
	public static User getUserDataToRead() {
		User user = new User();
		user.setEmployeeId("A71852");
		user.setFirstName("Ravi");
		user.setLastName("Verma");
		user.setUserId(1);
		
		return user;
	}
	
	public static User getUserDataToWrite() {
		User user = new User("Tanisha", "Gupta", "T71929P");
		return user;
	}
	
	public static Task getTaskDataToRead() {
		Task task = new Task();
		
		task.setTaskId(12);
		task.setPriority(8);
		task.setTaskName("Child task for checkbox validation after task creation on load ");
		task.setStartDate(dateFromString("08/31/2019"));
		task.setEndDate(dateFromString("11/26/2019"));
		task.setStatus("New");
		task.setUser(getUserDataToRead());
		
		return task;
	}
	
	public static Task getTaskDataToWrite() {
		Task task = new Task("Testing task for Junit Test.", dateFromString("09/22/2019"), dateFromString("12/11/2019"), 
				24, "New", getParentTaskDataToRead(), getProjectDataToRead());
		
		return task;
	}
	
	public static ParentTask getParentTaskDataToRead() {
		ParentTask parentTask = new ParentTask(9, "Parent task for checkbox validation on load after task creation");
		return parentTask;
	}
	
	public static ParentTask getParentTaskDataToWrite() {
		ParentTask parentTask = new ParentTask();
		
		parentTask.setParentTask("Testing parent task for Junit validation.");
		parentTask.setProject(getProjectDataToRead());
		
		return parentTask;
	}
	
	public static Date dateFromString(final String sDate) {
		String dateFormat = "MM/dd/yyyy";
		final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
		try {
			return sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
