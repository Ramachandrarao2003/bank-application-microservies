package com.bank.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.bank.dto.AccountResponse;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountFeignClient {
	
	@GetMapping("/accounts/all")
	List<AccountResponse> getAllAccounts();
	
	@PutMapping("/accounts/block/{accountNumber}")
	public AccountResponse blockAccount(@PathVariable String accountNumber);
	
	@PutMapping("/accounts/activate/{accountNumber}")
	public AccountResponse activateAccount(@PathVariable String accountNumber);
	
	@PutMapping("/accounts/close/{accountNumber}")
	public AccountResponse closeAccount(@PathVariable String accountNumber);
	
	@GetMapping("/accounts/{accountNumber}")
	public AccountResponse getAccount(@PathVariable String accountNumber);

}
