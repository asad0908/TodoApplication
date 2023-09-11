package com.seclore.todo.exception;

import java.sql.DataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The GlobalExceptionHandler class is a controller advice class that handles
 * global exceptions and provides custom responses for specific exception types.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handle the DuplicateKeyException by returning a response with a conflict
	 * status (HTTP 409) and a message extracted from the exception.
	 *
	 * @param e The DuplicateKeyException that was thrown.
	 * @return ResponseEntity with a conflict status and a message indicating the
	 *         duplicate key issue.
	 */
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<String> duplicateKeyExceptionHandler(DuplicateKeyException e) {
		String message = e.getMessage();
		message = message.substring(message.lastIndexOf(": ") + 2);
		// System.out.println("Duplicate key");
		return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
	}

	/**
	 * Handle the EmptyResultDataAccessException by returning a response with a not
	 * found status (HTTP 404) and a message indicating that no records were found.
	 *
	 * @param e The EmptyResultDataAccessException that was thrown.
	 * @return ResponseEntity with a not found status and a message indicating no
	 *         records were found.
	 */
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> emptyDataExceptionHandler(EmptyResultDataAccessException e) {
		// System.out.println("Empty data");
		String message = "No records found!";
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle the SQLIntegrityConstraintViolationException by returning a response
	 * with a bad request status (HTTP 400) and a message indicating incomplete data
	 * or constraint violation.
	 *
	 * @param e The SQLIntegrityConstraintViolationException that was thrown.
	 * @return ResponseEntity with a bad request status and a message indicating
	 *         incomplete data or constraint violation.
	 */
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<String> invalidInputExceptionHandler(SQLIntegrityConstraintViolationException e) {
		// System.out.println("Incomplete data");
		String message = "Incomplete data! " + e.getMessage();
//		message = message.substring(message.lastIndexOf(": ") + 2, message.lastIndexOf("at row"));
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle the DataTruncation exception by returning a response with a bad
	 * request status (HTTP 400) and a message indicating data truncation issue.
	 *
	 * @param e The DataTruncation exception that was thrown.
	 * @return ResponseEntity with a bad request status and a message indicating
	 *         data truncation issue.
	 */
	@ExceptionHandler(DataTruncation.class)
	public ResponseEntity<String> dataViolationceptionHandler(DataTruncation e) {
		// System.out.println("Long data");
		String message = e.getMessage();
		message = message.substring(message.lastIndexOf(": ") + 2, message.lastIndexOf("at row"));
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CAuthenticationException.class)
	public ResponseEntity<String> customAuthenticationExceptionHandler(CAuthenticationException e) {
		System.out.println("Invalid creds");
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.UNAUTHORIZED);
	}

}

/*
 * 
 * System.out.println("Message: " + e.getMessage());
 * System.out.println("LocalMessage: " + e.getLocalizedMessage());
 * System.out.println("error code: " + e.getErrorCode());
 * System.out.println("SQL state: " + e.getSQLState());
 * System.out.println("error code: " + e.());
 * System.out.println("most specifv cause: " + e.getMostSpecificCause());
 * System.out.println("most specifv cause: " + e.getRootCause());
 * System.out.println("cause: " + e.getCause());
 * 
 */
