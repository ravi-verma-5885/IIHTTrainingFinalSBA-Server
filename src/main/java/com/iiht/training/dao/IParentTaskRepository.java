package com.iiht.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.model.ParentTask;

@Repository
public interface IParentTaskRepository extends JpaRepository<ParentTask, Long>{

}
