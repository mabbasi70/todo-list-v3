package com.mohammad.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mohammad.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Task> getTasks() {
		Session session = sessionFactory.getCurrentSession();
		Query<Task> theQuery = session.createQuery("from Task", Task.class);
		List<Task> tasks = theQuery.getResultList();
		return tasks;
	}

	@Override
	public void saveTask(Task theTask) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theTask);
		
	}

	@Override
	public Task getTasks(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Task theTask = session.get(Task.class, theId);
		return theTask;
	}

	@Override
	public void deleteTask(int taskId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Task where id=:taskId");
		theQuery.setParameter("taskId", taskId);
		theQuery.executeUpdate();
		
	}
	

}
