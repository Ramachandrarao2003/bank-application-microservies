package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<?> handleAccountNotFount(AccountNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<?> handleBalance(InsufficientBalanceException ex){
		
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
