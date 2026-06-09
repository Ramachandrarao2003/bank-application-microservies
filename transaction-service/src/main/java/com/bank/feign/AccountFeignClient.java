package com.bank.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.dto.AccountResponse;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountFeignClient {
	
	@GetMapping("/accounts/{accountNumber}")
	public AccountResponse getAccount(@PathVariable String accountNumber);
	
	@PutMapping("/accounts/deposit/{accountNumber}")
	public AccountResponse deposit(@PathVariable String accountNumber,
									@RequestParam Double amount);
	
	@PutMapping("/accounts/withdraw/{accountNumber}")
	public AccountResponse withdraw(@PathVariable String accountNumber,
									@RequestParam Double amount);

}
