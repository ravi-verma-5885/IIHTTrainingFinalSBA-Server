package com.iiht.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.model.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long>{

}
