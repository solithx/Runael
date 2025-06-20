package com.runael.user.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.runael.user.model.User;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByEmail(String email);
    Mono<User> findByPhone(String phone);
    Mono<Boolean> existsByEmail(String email);
    Mono<Boolean> existsByPhone(String phone);



}

