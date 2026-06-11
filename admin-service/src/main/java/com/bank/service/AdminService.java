package com.bank.service;

import java.util.List;

import com.bank.dto.AccountResponse;
import com.bank.dto.DashboardResponse;
import com.bank.dto.TransactionResponse;
import com.bank.dto.UserResponse;

public interface AdminService {
	
	public List<UserResponse> getAllUsers();
	public List<AccountResponse> getAllAccounts();
	public List<TransactionResponse> getAllTransactions();
	
	public AccountResponse blockAccount(String accountNumber);
	public AccountResponse activateAccount(String accountNumber);
	public AccountResponse closeAccount(String accountNumber);
	
	public DashboardResponse getDashboard();
	
	public UserResponse getUser(Long userId);
	public AccountResponse getAccount(String accountNumber);
	public TransactionResponse getTransaction(Long transactionId);

}
