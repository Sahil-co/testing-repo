package com.project.ebug.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private Long id;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="project_type")
	private String type;
	
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
