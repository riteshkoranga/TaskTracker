package com.ritesh.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.task.model.taskitem;
import com.ritesh.task.repo.taskrepo;



@Service
public class taskservices {
	@Autowired
	private taskrepo torepo;
	
	public Iterable<taskitem> findAll(){
		return torepo.findAll();
	}
	
	public Optional<taskitem> getbyid(Long id)
	{
		return torepo.findById(id);
	}
	
	public taskitem save(taskitem item) {
		return torepo.save(item);
	}
	
	public void delete(taskitem item)
	{
		torepo.delete(item);
	}
	
}
