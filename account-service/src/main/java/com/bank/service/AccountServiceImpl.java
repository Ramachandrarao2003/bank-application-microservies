package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;
import com.bank.dto.UserResponse;
import com.bank.entity.Account;
import com.bank.enums.AccountStatus;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.InsufficientBalanceException;
import com.bank.feign.AuthFeignClient;
import com.bank.repository.AccountRepository;
import com.bank.security.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepo;
	private final AuthFeignClient authFeignClient;
	private final JwtService jwtService;


	@Override
	public AccountResponse getAccount(String accountNumber) {
		
		Account account = accountRepo.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Found"));
		
		return map(account);
	}

	@Override
	public AccountResponse deposit(String accountNumber, Double amount) {
		Account account = accountRepo.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Found"));
		
		account.setBalance(account.getBalance() +amount);
		accountRepo.save(account);
		return map(account);
	}

	@Override
	public AccountResponse withdraw(String accountNumber, Double amount) {
		Account account = accountRepo.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Found"));
		
		if(account.getBalance() < amount) {
			throw new InsufficientBalanceException("Insufficient Balance");			
		}
		
		account.setBalance(account.getBalance() - amount);
		accountRepo.save(account);
		
		return map(account);
	}

	@Override
	public List<AccountResponse> getAllAccounts() {
		
		return accountRepo.findAll()
				.stream()
				.map(this::map)
				.toList();
	}
	
	
	private AccountResponse map(Account account) {
		
		return AccountResponse.builder()
				.accountId(account.getAccountId())
				.userId(account.getUserId())
				.customerName(account.getCustomerName())
				.accountNumber(account.getAccountNumber())
				.phone(account.getPhone())
				.accountType(account.getAccountType())
				.balance(account.getBalance())
				.status(account.getStatus().name())
				.createdAt(account.getCreatedAt())
				.build();
	}
	
	/*private String generateAccountNumber() {
		
		return "ACC" + String.valueOf(System.currentTimeMillis()).substring(6);
	} */
	
	private String generateAccountNumber() {
		
		return String.valueOf(100000000000L + (long)(Math.random()* 900000000000L));
	}

	@Override
	public AccountResponse createAccount(String authHeader, AccountRequest request) {
		
		String token = authHeader.substring(7);
		String email = jwtService.extractUsername(token);
		UserResponse user = authFeignClient.getUserByEmail(email);
		
		Long userId = user.getId();
		
		log.info("Create account for userId: {}",userId);
		
		if(request.getBalance() < 500) {
			throw new RuntimeException("Minimum opening balance is 500");		
		}
		
		Account account =Account.builder()
				.userId(userId)
				.customerName(user.getName())
				.phone(request.getPhone())
				.accountType(request.getAccountType())
				.accountNumber(generateAccountNumber())
				.balance(request.getBalance())
				.status(AccountStatus.ACTIVE)
				.createdAt(LocalDateTime.now())
				.build();
		
		accountRepo.save(account);
		
		log.info("Account Created Successfully : {}",account.getAccountNumber());
		
		return map(account);
	}

	@Override
	public AccountResponse blockAccount(String accountNumber) {
		
		Account account = accountRepo
				.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Fount"));
		
		account.setStatus(AccountStatus.BLOCKED);
		accountRepo.save(account);
		
		log.info("Account Blocked : {}",accountNumber);
		
		return map(account);
	}

	@Override
	public AccountResponse activateAccount(String accountNumber) {
		
		Account account = accountRepo
				.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Fount"));
		
		account.setStatus(AccountStatus.ACTIVE);
		accountRepo.save(account);
		
		log.info("Account Activated : {}",accountNumber);
		
		return map(account);
	}

	@Override
	public AccountResponse closeAccount(String accountNumber) {
		
		Account account = accountRepo
				.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account Not Fount"));
		
		account.setStatus(AccountStatus.CLOSED);
		accountRepo.save(account);
		
		log.info("Account Activated : {}",accountNumber);
		
		return map(account);
	}

}
