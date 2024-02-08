package com.ritesh.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.task.model.taskitem;

public interface taskrepo extends JpaRepository<taskitem,Long> {

}
