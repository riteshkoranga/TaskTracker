package com.ritesh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritesh.todo.model.todoitem;
import com.ritesh.todo.service.todoservices;
import org.springframework.ui.Model;


@Controller

public class todoFormController {
	@Autowired
	private todoservices service;
	
	
	@GetMapping("/create")
	public String showcreate(todoitem todo)
	{
		return "newtodo";
	}
	
	
	@PostMapping("/todo")
	public String createtodo(@Validated todoitem todo  ,BindingResult result,Model model)
	{
		todoitem item=new todoitem();
		item.setTitle(todo.getTitle());
		item.setDone(todo.isDone());
		
		service.save(todo);
		return "redirect:/";
		
	}
	
	
	  @GetMapping("/delete/{id}") 
	  public String deletetodo(@PathVariable("id") Long id)
	  { todoitem item=service.getbyid(id).orElseThrow();
	  
	  service.delete(item); 
	  return
	  "redirect:/"; }
	 
	  
	  @GetMapping("/edit/{id}")
	  public String Edittodo(@PathVariable("id") Long id,Model model)
	  {
		  todoitem item=service.getbyid(id).orElseThrow();
		  model.addAttribute("todo",item);
		  return "edit-todo";
	  }
	  
	 @PostMapping("/todo/{id}")
	 public String updatetodo(@PathVariable("id") Long id,todoitem todoitem,BindingResult result)
	 {	
		 
	 todoitem item=service.getbyid(id).orElseThrow();
	 item.setDone(todoitem.isDone()); 
	  item.setTitle(todoitem.getTitle());
	  service.save(item);
	  return "redirect:/";
	  }
	
	
}
