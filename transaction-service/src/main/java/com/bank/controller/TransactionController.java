package com.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.TransactionResponse;
import com.bank.dto.TransferRequest;
import com.bank.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
	
	private final TransactionService service;
	
	@PostMapping("/transfer")
	public ResponseEntity<TransactionResponse> transfer(@RequestBody TransferRequest request){
		
		return ResponseEntity.ok(service.transfer(request));
	}
	
	@GetMapping("/history/{accountNumber}")
	public ResponseEntity<List<TransactionResponse>> getTransactions(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.getTransactions(accountNumber));
	}
	

}
