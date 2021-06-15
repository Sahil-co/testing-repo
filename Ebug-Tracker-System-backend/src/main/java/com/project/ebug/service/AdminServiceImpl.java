package com.project.ebug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ebug.dao.ProjectDao;
import com.project.ebug.entity.Project;
import com.project.ebug.exceptions.ProjectNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	ProjectDao projectDao;

	@Override
	public Project addProject(Project project) {
		return projectDao.saveAndFlush(project);
	}

	@Override
	public Project updateProject(Long id, Project project) {
		Project updatedProject = projectDao.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
		updatedProject.setName(project.getName());
		updatedProject.setType(project.getType());
		updatedProject.setDescription(project.getDescription());
		projectDao.save(updatedProject);
		return updatedProject;
	}

	@Override
	public void deleteProject(Long id) {
		Project project = projectDao.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
		projectDao.deleteById(id);
	}

	@Override
	public Project viewProject(Long id) {
		Project proj = projectDao.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));;
		return proj;
	}

	@Override
	public List<Project> viewAllProjects() {
		return projectDao.findAll();
	}

	
}
