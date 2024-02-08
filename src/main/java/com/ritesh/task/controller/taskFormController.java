package com.ritesh.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritesh.task.model.taskitem;
import com.ritesh.task.service.taskservices;
import org.springframework.ui.Model;


@Controller

public class taskFormController {
	@Autowired
	private taskservices service;
	
	
	@GetMapping("/create")
	public String showcreate(taskitem task)
	{
		return "newtask";
	}
	
	
	@PostMapping("/task")
	public String createtask(@Validated taskitem task  ,BindingResult result,Model model)
	{
		taskitem item=new taskitem();
		item.setTitle(task.getTitle());
		item.setDone(task.isDone());
		
		service.save(task);
		return "redirect:/";
		
	}
	
	
	  @GetMapping("/delete/{id}") 
	  public String deletetask(@PathVariable("id") Long id)
	  { taskitem item=service.getbyid(id).orElseThrow();
	  
	  service.delete(item); 
	  return
	  "redirect:/"; }
	 
	  
	  @GetMapping("/edit/{id}")
	  public String Edittask(@PathVariable("id") Long id,Model model)
	  {
		  taskitem item=service.getbyid(id).orElseThrow();
		  model.addAttribute("task",item);
		  return "edit-task";
	  }
	  
	 @PostMapping("/task/{id}")
	 public String updatetask(@PathVariable("id") Long id,taskitem taskitem,BindingResult result)
	 {	
		 
	 taskitem item=service.getbyid(id).orElseThrow();
	 item.setDone(taskitem.isDone()); 
	  item.setTitle(taskitem.getTitle());
	  service.save(item);
	  return "redirect:/";
	  }
	
	
}
