package com.project.ebug.service;

import java.util.List;

import com.project.ebug.entity.Project;

public interface AdminService {

	public Project addProject(Project project);
	
	public Project updateProject(Long id, Project project);
	
	public void deleteProject(Long id);
	
	public Project viewProject(Long id);
	
	public List<Project> viewAllProjects();
}
