package com.runael.auth.repository;

import com.runael.auth.model.Credential;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AuthUserRepository extends ReactiveCrudRepository<Credential, UUID> {
    Mono<Credential> findByEmail(String email);

    Mono<Credential> findByPhone(String phone);
}
