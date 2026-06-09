package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dto.AccountResponse;
import com.bank.dto.TransactionResponse;
import com.bank.dto.TransferRequest;
import com.bank.entity.Transaction;
import com.bank.enums.TransactionStatus;
import com.bank.enums.TransactionType;
import com.bank.feign.AccountFeignClient;
import com.bank.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {
	
	private final TransactionRepository transactionRepo;
	private final AccountFeignClient accountFeign;

	@Override
	@Transactional
	public TransactionResponse transfer(TransferRequest request) {
		
		log.info("Transfer Started From {} to {} Amount {}",
				request.getFromAccount(),
				request.getToaccount(),
				request.getAmount());
		
		AccountResponse source = accountFeign.getAccount(request.getFromAccount());
		AccountResponse destination = accountFeign.getAccount(request.getToaccount());
		
		if(source == null) {
			throw new RuntimeException("Source Account Not Found");
		}
		
		if(destination == null) {
			throw new RuntimeException("Destination Account Not Found");
		}
		
		if(source.getBalance() < request.getAmount()) {
			throw new RuntimeException("Insufficient Balance");
		}
		
		accountFeign.withdraw(request.getFromAccount(), request.getAmount());
		accountFeign.deposit(request.getToaccount(), request.getAmount());
		
		Transaction transaction = Transaction.builder()
				.fromAccount(request.getFromAccount())
				.toAccount(request.getToaccount())
				.amount(request.getAmount())
				.transactionType(TransactionType.TRANSFER)
				.status(TransactionStatus.SUCCESS)
				.description("Fund Transfer")
				.transactionDate(LocalDateTime.now())
				.build();
		
		transactionRepo.save(transaction);
		
		log.info("Transfer Completed : {} -> {}",
				request.getFromAccount(),request.getToaccount());
		
		return map(transaction);
	}

	@Override
	public List<TransactionResponse> getTransactions(String accountNumber) {
		
		return transactionRepo.findByFromAccountOrToAccount(accountNumber, accountNumber)
				.stream()
				.map(this::map)
				.toList();
	}
	
	private TransactionResponse map(Transaction transaction) {
		
		return TransactionResponse.builder()
				.transactionId(transaction.getTransactionId())
				.fromAccount(transaction.getFromAccount())
				.toAccount(transaction.getToAccount())
				.amount(transaction.getAmount())
				.transactionType(transaction.getTransactionType().name())
				.status(transaction.getStatus().name())
				.description(transaction.getDescription())
				.transactionDate(transaction.getTransactionDate())
				.build();
	}

}
