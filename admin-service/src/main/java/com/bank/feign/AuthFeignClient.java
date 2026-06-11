package com.bank.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.dto.UserResponse;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthFeignClient {
	
	@GetMapping("/auth/users")
	List<UserResponse> getAllUsers();
	
	@GetMapping("/auth/user/{id}")
	UserResponse getUser(@PathVariable Long id);

}
