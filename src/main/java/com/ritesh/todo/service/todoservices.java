package com.ritesh.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.todo.model.todoitem;
import com.ritesh.todo.repo.todorepo;



@Service
public class todoservices {
	@Autowired
	private todorepo torepo;
	
	public Iterable<todoitem> findAll(){
		return torepo.findAll();
	}
	
	public Optional<todoitem> getbyid(Long id)
	{
		return torepo.findById(id);
	}
	
	public todoitem save(todoitem item) {
		return torepo.save(item);
	}
	
	public void delete(todoitem item)
	{
		torepo.delete(item);
	}
	
}
