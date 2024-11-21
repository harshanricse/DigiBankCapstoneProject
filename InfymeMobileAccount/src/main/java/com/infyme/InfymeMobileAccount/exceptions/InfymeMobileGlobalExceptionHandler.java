package com.infyme.InfymeMobileAccount.exceptions;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InfymeMobileGlobalExceptionHandler {
	@Autowired
	private Environment env;
	@ExceptionHandler
	ResponseEntity<ErrorInformation> exceptionHandler(InfymeMobileException e){		
		ErrorInformation error = new ErrorInformation();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(e.getMessage());
		error.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);		
		
	}
	
	@ExceptionHandler(Exception.class )
	ResponseEntity<ErrorInformation> exceptionHandler(Exception ex){
		ErrorInformation error = new ErrorInformation();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(((BindException) ex).getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(". ")));
		error.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
}
