package com.bank.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.dto.AuthResponse;
import com.bank.dto.LoginRequest;
import com.bank.dto.RegisterRequest;
import com.bank.entity.User;
import com.bank.repository.UserRepository;
import com.bank.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final  UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

	
	@Override
	public String register(RegisterRequest request) {
		User user = User.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();
		
		userRepository.save(user);
		
		return "User Registered Successfully";
	}

	@Override
	public AuthResponse login(LoginRequest request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();
		
		String token = jwtService.generateToken(user);
		
		return new AuthResponse(token);
	}

}
