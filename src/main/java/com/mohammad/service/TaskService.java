package com.mohammad.service;

import java.util.List;

import com.mohammad.model.DoneTask;
import com.mohammad.model.Task;

public interface TaskService {

	public List<Task> getTasks();

	public void saveTask(Task theTask);

	public Task getTask(int theId);

	public void deleteTask(int taskId);

	public List<DoneTask> getDoneTasks();

	public void saveDoneTask(DoneTask doneTask, int id);

	public void deleteDoneTask(int taskId);
	
	
	

}
