package com.runael.auth.service;

import com.runael.auth.dto.AuthResponse;
import com.runael.auth.dto.LoginRequest;
import com.runael.auth.dto.RegisterRequest;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<AuthResponse> register(RegisterRequest request);

    Mono<AuthResponse> login(LoginRequest request);
}
