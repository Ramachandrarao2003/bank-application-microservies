package com.bank.controller;

import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@Operation(summary = "Register New User",description = "Creates a new user account")
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
		
		return ResponseEntity.ok(authService.register(request));
	}
	
	@Operation(summary = "User Login",description = "Generates JWT Token")
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
		
		return ResponseEntity.ok(authService.login(request));
	}
	
	@Operation(summary = "Get User By Email",description = "Fetch user details using email")
	@GetMapping("/email/{email}")
	public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email){
		
		return ResponseEntity.ok(authService.getUserByEmail(email));
	}
	
	@Operation(summary = "Get User By ID",description = "Fetch user details using user id")
	@GetMapping("/user/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
		
		return ResponseEntity.ok(authService.getUser(id));
	}
	
	@Operation(summary = "Get All Users",description = "Returns all registered users")
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		
		return ResponseEntity.ok(authService.getAllUsers());
	}
	
	

}
