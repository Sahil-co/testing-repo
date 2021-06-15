package com.project.ebug.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ebug.entity.Project;

@Repository("project")
public interface ProjectDao extends JpaRepository<Project, Long>{

}
