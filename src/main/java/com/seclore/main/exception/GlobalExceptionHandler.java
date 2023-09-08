package com.seclore.main.exception;

import java.sql.DataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<String> duplicateKeyExceptionHandler(DuplicateKeyException e) {
		String message = e.getMessage();
		message = message.substring(message.lastIndexOf(": ") + 2);
		System.out.println("Duplicate key");
		return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> emptyDataExceptionHandler(EmptyResultDataAccessException e) {
		System.out.println("Empty data");
		String message = "Record Not Found!";
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)

	public ResponseEntity<String> invalidInputExceptionHandler(SQLIntegrityConstraintViolationException e) {
		System.out.println("Incomplete data");
		String message = "Incomplete data! " + e.getMessage();
		message = message.substring(message.lastIndexOf(": ")+2, message.lastIndexOf("at row"));
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataTruncation.class)
	public ResponseEntity<String> dataViolationceptionHandler(DataTruncation e) {
		System.out.println("Long data");
		String message = e.getMessage();
		message = message.substring(message.lastIndexOf(": ") + 2, message.lastIndexOf("at row"));
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

}


/*
 
 		System.out.println("Message: " + e.getMessage());
		System.out.println("LocalMessage: " + e.getLocalizedMessage());
		System.out.println("error code: " + e.getErrorCode());
		System.out.println("SQL state: " + e.getSQLState());
		System.out.println("error code: " + e.());
		System.out.println("most specifv cause: " + e.getMostSpecificCause());
		System.out.println("most specifv cause: " + e.getRootCause());
		System.out.println("cause: " + e.getCause());
		
*/
