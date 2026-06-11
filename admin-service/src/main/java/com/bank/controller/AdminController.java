package com.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountResponse;
import com.bank.dto.DashboardResponse;
import com.bank.dto.TransactionResponse;
import com.bank.dto.UserResponse;
import com.bank.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getUsers(){
		
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/accounts/all")
	public ResponseEntity<List<AccountResponse>> getAccounts(){
		
		return ResponseEntity.ok(service.getAllAccounts());
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionResponse>> getTransactions(){
		
		return ResponseEntity.ok(service.getAllTransactions());
	}
	
	@PutMapping("/block/{accountNumber}")
	public ResponseEntity<AccountResponse> blockAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.blockAccount(accountNumber));
	}
	
	@PutMapping("/activate/{accountNumber}")
	public ResponseEntity<AccountResponse> activateAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.activateAccount(accountNumber));
	}
	
	@PutMapping("/close/{accountNumber}")
	public ResponseEntity<AccountResponse> closeAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.closeAccount(accountNumber));
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponse> dashboard(){
		
		return ResponseEntity.ok(service.getDashboard());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
		
		return ResponseEntity.ok(service.getUser(userId));
	}
	
	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.getAccount(accountNumber));
	}
	
	@GetMapping("/transaction{transactionId}")
	public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Long transactionId){
		
		return ResponseEntity.ok(service.getTransaction(transactionId));
	}

}
