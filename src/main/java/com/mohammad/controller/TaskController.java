package com.mohammad.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohammad.model.Task;
import com.mohammad.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@GetMapping("/list")
	public String listTodoList(Model theModel) {
		
		List<Task> theTasks = taskService.getTasks();
		theModel.addAttribute("tasks", theTasks);
		
		return "task-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Task theTask = new Task();
		theModel.addAttribute("task", theTask);
		
		return "task-form";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@Valid @ModelAttribute("task") Task theTask, BindingResult theBindingResult) {
		
		
		System.out.println(theBindingResult);
		if(theBindingResult.hasErrors()) {
			return "task-form";
		}else {
			taskService.saveTask(theTask);
			return "redirect:/task/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("taskId")int theId,
			Model theModel) {
		
		Task theTask = taskService.getTask(theId);
		theModel.addAttribute("task",theTask);
		return "task-form";
	}
	
	@GetMapping("/delete")
	public String deleteTask(@RequestParam("taskId")int taskId) {
		
		taskService.deleteTask(taskId);
		return "redirect:/task/list/";
	}
	

}
