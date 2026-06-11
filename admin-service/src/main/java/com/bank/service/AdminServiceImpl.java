package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dto.AccountResponse;
import com.bank.dto.DashboardResponse;
import com.bank.dto.TransactionResponse;
import com.bank.dto.UserResponse;
import com.bank.feign.AccountFeignClient;
import com.bank.feign.AuthFeignClient;
import com.bank.feign.TransactionFeignClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {
	
	private final AuthFeignClient authFeign;
	private final AccountFeignClient accountFeign;
	private final TransactionFeignClient txnFeign;

	@Override
	public List<UserResponse> getAllUsers() {
		
		log.info("Fetching all users");
		
		return authFeign.getAllUsers();
	}

	@Override
	public List<AccountResponse> getAllAccounts() {
		
		log.info("Fetching all accounts");
		
		return accountFeign.getAllAccounts();
	}

	@Override
	public List<TransactionResponse> getAllTransactions() {
		
		log.info("Fetching all transactions");
		
		return txnFeign.getAllTransactions();
	}

	@Override
	public AccountResponse blockAccount(String accountNumber) {
		
		log.info("Blocking Account {}",accountNumber);
		
		return accountFeign.blockAccount(accountNumber);
	}

	@Override
	public AccountResponse activateAccount(String accountNumber) {
		
		return accountFeign.activateAccount(accountNumber);
	}

	@Override
	public AccountResponse closeAccount(String accountNumber) {
		
		return accountFeign.closeAccount(accountNumber);
	}

	@Override
	public DashboardResponse getDashboard() {
		
		List<UserResponse> users = authFeign.getAllUsers();
		List<AccountResponse> accounts = accountFeign.getAllAccounts();
		List<TransactionResponse> txns = txnFeign.getAllTransactions();
		
		double totalBalance = accounts.stream()
								.mapToDouble(AccountResponse::getBalance)
								.sum();
		
		return DashboardResponse.builder()
				.totalUsers(users.size())
				.totalAccounts(accounts.size())
				.totalTransactions(txns.size())
				.totalBalance(totalBalance)
				.build();
	}

	@Override
	public UserResponse getUser(Long userId) {
		
		log.info("Fetching User {}", userId);
		
		return authFeign.getUser(userId);
	}

	@Override
	public AccountResponse getAccount(String accountNumber) {
		
		log.info("Fetching Account {}",accountNumber);
		
		return accountFeign.getAccount(accountNumber);
	}

	@Override
	public TransactionResponse getTransaction(Long transactionId) {
		
		log.info("Fetching Transaction {}", transactionId);
		
		return txnFeign.getTransaction(transactionId);
	}

}
