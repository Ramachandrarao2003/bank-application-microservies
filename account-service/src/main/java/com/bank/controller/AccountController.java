package com.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;
import com.bank.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth")

public class AccountController {
	
	private final AccountService accountService;
	
	
	@Operation(summary = "Create Bank Account",description = "Creates a new Savings or Current account for the logged-in user")
	@PostMapping
	public ResponseEntity<AccountResponse> createAccount(@RequestHeader("Authorization")
								String authHeader,@RequestBody AccountRequest request){
		
		return ResponseEntity.ok(accountService.createAccount(authHeader, request));
	}
	
	@Operation(summary = "Get Account Details",description = "Fetch accont details using account number" )
	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.getAccount(accountNumber));
	}
	
	@Operation(summary ="Deposit Money",description = "Deposits money into a bank account" )
	@PutMapping("/deposit/{accountNumber}")
	public ResponseEntity<AccountResponse> deposit(@PathVariable String accountNumber,
												   @RequestParam Double amount){
		
		return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
	}
	
	@Operation(summary ="Withdraw Money",description = "Withdraws money from a bank account" )
	@PutMapping("/withdraw/{accountNumber}")
	public ResponseEntity<AccountResponse> withdraw(@PathVariable String accountNumber,
													@RequestParam Double amount){
		
		return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));
	}
	
	@Operation(summary = "Get All Accounts",description = "Returns all bank accounts")
	@GetMapping("/all")
	public ResponseEntity<List<AccountResponse>> getAllAccounts(){
		
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@Operation(summary = "Block Account",description = "Changes account status from ACTIVE to BLOCKED")
	@PutMapping("/block/{accountNumber}")
	public ResponseEntity<AccountResponse> blockAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.blockAccount(accountNumber));
	}
	
	@Operation(summary = "Activate Account",description = "Changes account status from BLOCKED to ACTIVE")
	@PutMapping("/activate/{accountNumber}")
	public ResponseEntity<AccountResponse> activateAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.activateAccount(accountNumber));
	}
	
	@Operation(summary = "Close Account",description = "Permanently closes an account by changing status to CLOSED")
	@PutMapping("/close/{accountNumber}")
	public ResponseEntity<AccountResponse> closeAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.closeAccount(accountNumber));
	}

}
