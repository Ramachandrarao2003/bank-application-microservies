package com.bank.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.dto.UserResponse;

import jakarta.ws.rs.Path;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthFeignClient {
	
	@GetMapping("/auth/user/{id}")
	public UserResponse getUser(@PathVariable Long id);

}
