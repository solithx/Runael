package com.runael.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

    private static final long EXPIRATION_MS = 86400000; // 1 день
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // можно вынести в config

    public String generateToken(UUID userId, String email) {
        return Jwts.builder().setSubject(userId.toString()).claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS)).signWith(key)
                .compact();
    }
}
