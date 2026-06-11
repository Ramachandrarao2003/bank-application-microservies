package com.bank.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.dto.TransactionResponse;

@FeignClient(name = "TRANSACTION-SERVICE")
public interface TransactionFeignClient {
	
	@GetMapping("/transactions")
	List<TransactionResponse> getAllTransactions();
	
	@GetMapping("/transactions/{transactionId}")
	TransactionResponse getTransaction(@PathVariable Long transactionId);

}
