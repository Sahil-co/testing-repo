package com.project.ebug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ebug.dao.ProjectDao;
import com.project.ebug.entity.Project;

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
		Optional<Project> proj = projectDao.findById(id);
		Project p = proj.get();
		p.setName(project.getName());
		p.setType(project.getType());
		p.setDescription(project.getDescription());
		projectDao.save(p);
		return p;
	}

	@Override
	public void deleteProject(Long id) {
		projectDao.deleteById(id);
	}

	@Override
	public Project viewProject(Long id) {
		Optional<Project> proj = projectDao.findById(id);
		return proj.get();
	}

	@Override
	public List<Project> viewAllProjects() {
		return projectDao.findAll();
	}

	
}
