package com.jps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@RestController
public class CustomExceptionHandler {
	
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(IdNotFoundException ex, WebRequest request){
    	ProjectIdNotFound exceptionResponse = new ProjectIdNotFound(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

	
    @ExceptionHandler
    public final ResponseEntity<Object> handleBrandException(BrandNotFoundException ex, WebRequest request){
    	BrandNotFound exceptionResponse = new BrandNotFound(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
	
}
