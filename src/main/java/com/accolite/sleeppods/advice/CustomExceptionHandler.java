package com.accolite.sleeppods.advice;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.accolite.sleeppods.exception.BadRequestException;

@RestControllerAdvice
public class CustomExceptionHandler {

	private final Logger logger = Logger.getLogger(ExceptionHandler.class);
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String badRequest(BadRequestException e) {
		logger.warn(e);
		return e.getMessage();
	}
}
