package com.erpschool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerAdvisorController extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleTokenExpiredException(Exception exception,WebRequest wr) throws Exception {

		System.out.println("Token Dead now1" + exception.getMessage());
		return new ResponseEntity<>("Token Expired", HttpStatus.UNAUTHORIZED);
    }
}

