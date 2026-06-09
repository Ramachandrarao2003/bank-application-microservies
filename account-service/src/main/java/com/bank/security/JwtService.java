package com.bank.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkeymysecretkey";
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	public String extractUsername(String token) {
		
		return getClaims(token).getSubject();
	}
	public Claims getClaims(String token) {
		
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public boolean validateToken(String token) {
		
		try {
			getClaims(token);
			return true;
		} 
		catch(Exception e) {
			return false;
		}
	}
}
