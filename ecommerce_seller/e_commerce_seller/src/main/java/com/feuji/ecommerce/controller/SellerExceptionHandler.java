package com.feuji.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.feuji.ecommerce.exception.ProductNotFoundException;
import com.feuji.ecommerce.exception.SellerNotFoundException;

@RestControllerAdvice
public class SellerExceptionHandler {
	
	@ExceptionHandler(SellerNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,String> handleSellerException(SellerNotFoundException ex) {
		
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,String> handleProductException(ProductNotFoundException ex) {
		
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
		
	}

}
