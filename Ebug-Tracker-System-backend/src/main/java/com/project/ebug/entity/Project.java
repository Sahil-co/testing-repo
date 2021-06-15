package com.project.ebug.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="project")
public class Project{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private Long id;
	
	@NotNull(message="Project Name is mandatory")
	@Size(min = 5, message = "Project name must be minimum 5 characters")
	@Column(name="project_name")
	private String name;
	
	@NotNull(message="Project Type is mandatory")
	@Size(min = 5, message = "Project type must be minimum 5 characters")
	@Column(name="project_type")
	private String type;
	
	@NotNull(message="Project Description is mandatory")
	@Size(min = 5, message = "Project description must be minimum 5 characters")
	@Column(name="project_description")
	private String description;
	
	public Project() {
	}

	public Project(String name, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + "]";
	}
	
}
