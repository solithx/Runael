package com.runael.auth.service.impl;

import com.runael.auth.dto.AuthResponse;
import com.runael.auth.dto.LoginRequest;
import com.runael.auth.dto.RegisterRequest;
import com.runael.auth.model.Credential;
import com.runael.auth.repository.AuthUserRepository;
import com.runael.auth.service.AuthService;
import com.runael.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final R2dbcEntityTemplate template; // <--- добавлено

    @Override
    public Mono<AuthResponse> register(RegisterRequest request) {
        var credential = new Credential(UUID.randomUUID(), request.email(), request.phone(),
                passwordEncoder.encode(request.password()), LocalDateTime.now(), null);

        return template.insert(Credential.class).using(credential)
                .map(saved -> new AuthResponse(saved.getId(),
                        jwtService.generateToken(saved.getId(), saved.getEmail())));
    }

    @Override
    public Mono<AuthResponse> login(LoginRequest request) {
        return repository.findByEmail(request.email()).flatMap(user -> {
            if (passwordEncoder.matches(request.password(), user.getPasswordHash())) {
                return Mono.just(new AuthResponse(user.getId(),
                        jwtService.generateToken(user.getId(), user.getEmail())));

            } else {
                return Mono.error(new RuntimeException("Invalid credentials"));
            }
        });
    }
}

