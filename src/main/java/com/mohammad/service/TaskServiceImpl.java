package com.mohammad.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohammad.dao.DoneTaskDAO;
import com.mohammad.dao.TaskDAO;
import com.mohammad.model.DoneTask;
import com.mohammad.model.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDAO taskDAO;
	
	@Autowired
	DoneTaskDAO doneTaskDAO;

	@Override
	@Transactional
	public List<Task> getTasks() {
		
		return taskDAO.getTasks();
	}

	@Override
	@Transactional
	public void saveTask(Task theTask) {
		
		taskDAO.saveTask(theTask);
	}

	@Override
	@Transactional
	public Task getTask(int theId) {
		
		return taskDAO.getTasks(theId);
	}

	@Override
	@Transactional
	public void deleteTask(int taskId) {
		taskDAO.deleteTask(taskId);
		
	}

	@Override
	@Transactional
	public List<DoneTask> getDoneTasks() {
		
		return doneTaskDAO.getDoneTasks();
	}

	@Override
	@Transactional
	public void saveDoneTask(DoneTask doneTask,int id) {
		
		doneTaskDAO.saveDoneTask(doneTask);
		taskDAO.deleteTask(id);
		
	}

	@Override
	@Transactional
	public void deleteDoneTask(int taskId) {
		doneTaskDAO.deleteDoneTask(taskId);
		
	}

}
