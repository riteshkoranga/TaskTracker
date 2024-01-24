package com.ritesh.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Todo_items")
public class todoitem {
	
	@Id
	@GeneratedValue
	
	private long id;
	private String title;
	private boolean done;
	
	
	public todoitem()
	{
		
	}


	public todoitem(long id, String title, boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.done = done;
	}
	
	@Id
	@GeneratedValue

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}

	
	
}
