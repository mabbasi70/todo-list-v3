package com.mohammad.dao;

import java.util.List;


import com.mohammad.model.Task;

public interface TaskDAO {

	public List<Task> getTasks();

	public void saveTask(Task theTask);

	public Task getTasks(int theId);

	public void deleteTask(int taskId);
	
	
	

}
