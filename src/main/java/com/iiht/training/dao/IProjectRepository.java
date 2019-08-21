package com.iiht.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.model.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{

}
