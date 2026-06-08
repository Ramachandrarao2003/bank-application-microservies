package com.bank.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.bank.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkeymysecretkey";
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	public String generateToken(User user) {
		
		return Jwts.builder()
				.subject(user.getEmail())
				.claim("role", user.getRole())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(key)
				.compact();
	}
	
	private Claims getClaims(String token) {
		
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public String extractUsername(String token) {
		
		return getClaims(token).getSubject();
	}
	
	private boolean isTokenExpired(String token) {
		
		return getClaims(token)
				.getExpiration()
				.before(new Date());
	}
	
	public boolean validateToken(String token,String username) {
		
		return username.equals(extractUsername(token)) && !isTokenExpired(token);
	}


}
