package com.bank.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAccountNotFound(AccountNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorResponse.builder()
						.message(ex.getMessage())
						.status(404)
						.timestamp(LocalDateTime.now())
						.build());
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleBalance(InsufficientBalanceException ex){
		
		return ResponseEntity.badRequest()
				.body(ErrorResponse.builder()
						.message(ex.getMessage())
						.status(404)
						.timestamp(LocalDateTime.now())
						.build());
				
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		
		return ResponseEntity.internalServerError()
				.body(ErrorResponse.builder()
						.message(ex.getMessage())
						.status(500)
						.timestamp(LocalDateTime.now())
						.build());
	}
	
	@ExceptionHandler(AccountServiceUnavailableException.class)
	public ResponseEntity<?> handleUnavailable(AccountServiceUnavailableException ex){
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
								.body(Map.of(
										"message",
										ex.getMessage(),
										"timestamp",
										LocalDateTime.now()));
	}

}
