package com.bank.service;

import com.bank.dto.AuthResponse;
import com.bank.dto.LoginRequest;
import com.bank.dto.RegisterRequest;

public interface AuthService {
	
	public String register(RegisterRequest request);
	
	public AuthResponse login(LoginRequest request);

}
