package com.project.ebug.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling project not found exception
	@ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<ErrorInfo> projectNotFoundExceptionHandling(ProjectNotFoundException e, WebRequest request) {
		ErrorInfo error = new ErrorInfo(new Date(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	//handling global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> globalExceptionHandling(Exception e, WebRequest request) {
		ErrorInfo error = new ErrorInfo(new Date(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// handling custom validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> customValidationErrorHandling(MethodArgumentNotValidException exception) {
		ErrorInfo errorInfo = new ErrorInfo(new Date(), "Validation Error",
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

}
