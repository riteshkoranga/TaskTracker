package com.ritesh.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.todo.model.todoitem;

public interface todorepo extends JpaRepository<todoitem,Long> {

}
