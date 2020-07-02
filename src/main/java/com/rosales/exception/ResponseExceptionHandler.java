package com.rosales.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
	
	@ExceptionHandler(FilmeExistException.class)
	public final ResponseEntity<ExceptionResponse> filmeExist(FilmeExistException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.OK);
	}
	
	@ExceptionHandler(FilmeUnprocessableException.class)
	public final ResponseEntity<ExceptionResponse> filmeUnprocessable(FilmeUnprocessableException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ActorNumberExceededException.class)
	public final ResponseEntity<ExceptionResponse> actorNumberExceeded(ActorNumberExceededException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
	}

}
