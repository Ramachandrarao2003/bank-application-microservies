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

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService service;
	
	@Operation(summary = "Get All Users")
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getUsers(){
		
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@Operation(summary = "Get All Accounts" )
	@GetMapping("/accounts/all")
	public ResponseEntity<List<AccountResponse>> getAccounts(){
		
		return ResponseEntity.ok(service.getAllAccounts());
	}
	
	@Operation(summary = "Get All Transactions")
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionResponse>> getTransactions(){
		
		return ResponseEntity.ok(service.getAllTransactions());
	}
	
	@Operation(summary = "Block Account",description = "Block a bank account usng account number" )
	@PutMapping("/block/{accountNumber}")
	public ResponseEntity<AccountResponse> blockAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.blockAccount(accountNumber));
	}
	
	@Operation(summary = "Activate Account",description = "Activate a blocked account" )
	@PutMapping("/activate/{accountNumber}")
	public ResponseEntity<AccountResponse> activateAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.activateAccount(accountNumber));
	}
	
	@Operation(summary = "Close Account",description = "Permanently close an account")
	@PutMapping("/close/{accountNumber}")
	public ResponseEntity<AccountResponse> closeAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.closeAccount(accountNumber));
	}
	
	@Operation(summary = "Dashboard Statistics",description = "Return overall banking statistics" )
	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponse> dashboard(){
		
		return ResponseEntity.ok(service.getDashboard());
	}
	
	@Operation(summary = "Get User By ID",description = "Fetch user details using user ID")
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
		
		return ResponseEntity.ok(service.getUser(userId));
	}
	
	@Operation(summary = "Get Account By Account Number",description = "Fetch accont details")
	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(service.getAccount(accountNumber));
	}
	
	@Operation(summary = "Get Transaction By ID",description = "Fetch transaction details")
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Long transactionId){
		
		return ResponseEntity.ok(service.getTransaction(transactionId));
	}

}
