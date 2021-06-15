package com.project.ebug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ebug.entity.Project;
import com.project.ebug.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project newProject = adminService.addProject(project);
		return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProject/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project project){
		Project updatedProject = adminService.updateProject(id, project);
		return new ResponseEntity<>(updatedProject, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
		adminService.deleteProject(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/findProject/{id}")
	public ResponseEntity<Project> viewProject(@PathVariable("id") Long id){
		Project project = adminService.viewProject(id);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
	
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> viewAllProjects(){
		List<Project> projects = adminService.viewAllProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
}
