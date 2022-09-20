package com.emp.app.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.emp.app.service.impl.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

@Service
public class JwtConfig {
	@Autowired
	private Environment environment;

	public String generateToken(UserDetailsImpl userDetailsImpl) {
		Claims claims = new DefaultClaims();
		claims.put("FULLNAME", userDetailsImpl.getUsername());
		claims.put("USERNAME", userDetailsImpl.getUsername());
		claims.put("ROLE", userDetailsImpl.getAuthorities().iterator().next().getAuthority());
		claims.setIssuedAt(new Date());
		claims.setExpiration(new Date(System.currentTimeMillis() + (3600000)));
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, environment.getProperty("security-key")).compact();
	}
}
