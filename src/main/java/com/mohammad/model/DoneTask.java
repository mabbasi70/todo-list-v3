package com.mohammad.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="done_task")
public class DoneTask {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Lob
	@Column(name="description")
	private String description;
	
	@Column(name="done_date")
	private LocalDate doneDate;
	
	public DoneTask() {doneDate = LocalDate.now();}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(LocalDate doneDate) {
		this.doneDate = doneDate;
	}

	@Override
	public String toString() {
		return "DoneTask [id=" + id + ", taskName=" + taskName + ", description=" + description + ", doneDate="
				+ doneDate + "]";
	}
	

}
