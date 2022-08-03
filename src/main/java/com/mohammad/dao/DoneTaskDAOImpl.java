package com.mohammad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mohammad.model.DoneTask;

@Repository
public class DoneTaskDAOImpl implements DoneTaskDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<DoneTask> getDoneTasks() {
		Session session = sessionFactory.getCurrentSession();
		Query<DoneTask> theQuery = session.createQuery("from DoneTask", DoneTask.class);
		List<DoneTask> tasks = theQuery.getResultList();
		return tasks;
		
	}

	@Override
	public void saveDoneTask(DoneTask doneTask) {
		Session session = sessionFactory.getCurrentSession();
		session.save("DoneTask", doneTask);
		
		
	}

	@Override
	public void deleteDoneTask(int taskId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from DoneTask where id=:taskId");
		theQuery.setParameter("taskId", taskId);
		theQuery.executeUpdate();
		
	}

}
