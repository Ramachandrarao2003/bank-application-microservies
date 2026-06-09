package com.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AuthResponse;
import com.bank.dto.LoginRequest;
import com.bank.dto.RegisterRequest;
import com.bank.dto.UserResponse;
import com.bank.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
		
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
		
		return ResponseEntity.ok(authService.login(request));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email){
		
		return ResponseEntity.ok(authService.getUserByEmail(email));
	}
	
	

}
