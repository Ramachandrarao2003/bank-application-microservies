package com.bank.service;

import com.bank.dto.AuthResponse;
import com.bank.dto.LoginRequest;
import com.bank.dto.RegisterRequest;
import com.bank.dto.UserResponse;

public interface AuthService {
	
	public String register(RegisterRequest request);
	
	public AuthResponse login(LoginRequest request);
	
	public UserResponse getUserByEmail(String email);
	
	public UserResponse getUser(Long id);

}
