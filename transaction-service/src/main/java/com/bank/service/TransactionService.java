package com.bank.service;

import java.util.List;

import com.bank.dto.TransactionResponse;
import com.bank.dto.TransferRequest;

public interface TransactionService {
	
	public TransactionResponse transfer(TransferRequest request);
	
	public List<TransactionResponse> getTransactions(String accountNumber);
	
	public List<TransactionResponse> getAllTransactions();
	
	public TransactionResponse getTransaction(Long transactionId);
	

}
