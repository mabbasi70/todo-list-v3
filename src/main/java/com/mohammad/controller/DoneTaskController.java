package com.mohammad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohammad.model.DoneTask;
import com.mohammad.service.TaskService;

@Controller
@RequestMapping("/doneTask")
public class DoneTaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/list")
	public String listDoneTaskList(Model model) {
		List<DoneTask> doneTask = taskService.getDoneTasks();
		
		model.addAttribute("doneTasks", doneTask);
		
		return "done-list";
	}
	
	@GetMapping("/addToDone")
	public String addToDone(@RequestParam("taskId")int id,@RequestParam("taskName")String taskName,
			@RequestParam("taskDes")String description) {
		
		DoneTask doneTask = new DoneTask();
		doneTask.setTaskName(taskName);
		doneTask.setDescription(description);
		taskService.saveDoneTask(doneTask,id);
		
		return "redirect:/doneTask/list";
	}
	
	@GetMapping("/delete")
	public String deleteDoneTask(@RequestParam("taskId")int taskId) {
		
		taskService.deleteDoneTask(taskId);
		return "redirect:/doneTask/list/";
	}
	
	
}
