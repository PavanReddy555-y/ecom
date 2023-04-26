package com.feuji.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.feuji.ecommerce.exception.UserNotFoundException;

@RestControllerAdvice
public class ValidationHandler  {
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex) {
//		
//		Map<String,String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach(error -> {
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			errors.put(fieldName,message);
//		});
//		
//		return errors;
//		//return new ResponseEntity<Object>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,String> handleUserException(UserNotFoundException ex) {
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("error message", ex.getMessage());
		return errorMap;
	}

}
