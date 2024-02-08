package com.ritesh.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ritesh.task.service.taskservices;

@Controller
public class homecontroller {
	@Autowired
	private taskservices service;
	
	@GetMapping("")
	public ModelAndView index()
	{
		ModelAndView view=new ModelAndView("index");
		view.addObject("taskitems",service.findAll());
		return view;
	}
	

}
