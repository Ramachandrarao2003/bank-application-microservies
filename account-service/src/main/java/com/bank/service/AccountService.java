package com.bank.service;

import java.util.List;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;

public interface AccountService {
	
	public AccountResponse createAccount(String authHeader,AccountRequest request);
	public AccountResponse getAccount(String accountNumber);
	public AccountResponse deposit(String accountNumber,Double amount);
	public AccountResponse withdraw(String accountNumber,Double amount);
	public List<AccountResponse> getAllAccounts();

}
