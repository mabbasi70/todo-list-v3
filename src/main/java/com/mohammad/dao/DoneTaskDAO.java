package com.mohammad.dao;

import java.util.List;

import com.mohammad.model.DoneTask;

public interface DoneTaskDAO {
	
	List<DoneTask> getDoneTasks();

	void saveDoneTask(DoneTask doneTask);

	void deleteDoneTask(int taskId);

}
