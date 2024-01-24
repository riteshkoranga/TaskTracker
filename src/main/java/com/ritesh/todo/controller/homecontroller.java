package com.ritesh.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ritesh.todo.service.todoservices;

@Controller
public class homecontroller {
	@Autowired
	private todoservices service;
	
	@GetMapping("")
	public ModelAndView index()
	{
		ModelAndView view=new ModelAndView("index");
		view.addObject("todoitems",service.findAll());
		return view;
	}
	

}
