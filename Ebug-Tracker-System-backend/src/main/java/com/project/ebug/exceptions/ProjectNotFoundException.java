package com.project.ebug.exceptions;

public class ProjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException() {
	}
	
	public ProjectNotFoundException(String msg) {
		super(msg);
	}
}
