package com.bank.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.dto.UserResponse;


@FeignClient(name = "AUTH-SERVICE")
public interface AuthFeignClient {
	
	@GetMapping("/auth/email/{email}")
	public UserResponse getUserByEmail(@PathVariable("email") String email);

}
