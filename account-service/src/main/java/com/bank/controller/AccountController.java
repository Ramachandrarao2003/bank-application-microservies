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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	
	@PostMapping
	public ResponseEntity<AccountResponse> createAccount(@RequestHeader("Authorization")
								String authHeader,@RequestBody AccountRequest request){
		
		return ResponseEntity.ok(accountService.createAccount(authHeader, request));
	}
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.getAccount(accountNumber));
	}
	
	@PutMapping("/deposit/{accountNumber}")
	public ResponseEntity<AccountResponse> deposit(@PathVariable String accountNumber,
												   @RequestParam Double amount){
		
		return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
	}
	
	@PutMapping("/withdraw/{accountNumber}")
	public ResponseEntity<AccountResponse> withdraw(@PathVariable String accountNumber,
													@RequestParam Double amount){
		
		return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountResponse>> getAllAccounts(){
		
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@PutMapping("/block/{accountNumber}")
	public ResponseEntity<AccountResponse> blockAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.blockAccount(accountNumber));
	}
	
	@PutMapping("/activate/{accountNumber}")
	public ResponseEntity<AccountResponse> activateAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.activateAccount(accountNumber));
	}
	
	@PutMapping("/close/{accountNumber}")
	public ResponseEntity<AccountResponse> closeAccount(@PathVariable String accountNumber){
		
		return ResponseEntity.ok(accountService.closeAccount(accountNumber));
	}

}
