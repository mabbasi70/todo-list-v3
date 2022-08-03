package com.mohammad.model;


import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message = "Required")
	@Column(name="task_name")
	private String taskName;
	
	@Lob
	@Column(name="description")
	private String description;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="init_date")
	private LocalDate initDate;
	
	@Column(name="deadline")
	private String deadline;
	
	public Task() {initDate =LocalDate.now();}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getTaskName() {return taskName;}

	public void setTaskName(String taskName) {this.taskName = taskName;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

	public String getPriority() {return priority;}

	public void setPriority(String priority) {this.priority = priority;}

	public LocalDate getInitDate() {return initDate;}

//	public void setInitDate(LocalDate initDate) {
//		this.initDate = initDate;
//	}

	public String getDeadline() {return deadline ; }
	
	
	public void setDeadline(String deadline) {this.deadline = deadline;}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", description=" + description + ", priority=" + priority
				+ ", initDate=" + initDate + ", deadline=" + deadline + "]";
	}

	

}
