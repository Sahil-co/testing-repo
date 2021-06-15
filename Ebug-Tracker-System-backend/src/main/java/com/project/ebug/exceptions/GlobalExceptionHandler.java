package com.project.ebug.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProjectNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handlePolicyNotFoundException(ProjectNotFoundException e,HttpServletRequest request) {
		
		
		ErrorInfo error = new ErrorInfo();
		
		error.setUrl(request.getRequestURI());
		error.setMessage(e.getMessage());
		
		return error;
	}
	
}
