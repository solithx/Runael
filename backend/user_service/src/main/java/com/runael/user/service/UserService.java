package com.runael.user.service;

import com.runael.user.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getAllUsers();

    Mono<User> getUserById(Long id);

    Mono<User> getUserByPhone(String phone);

    Mono<User> getUserByEmail(String email);

    Mono<User> createUser(User user);

    Mono<User> updateUser(Long id, User updatedUser);

    Mono<Void> deleteUser(Long id);

    Mono<Boolean> existsByEmail(String email);

    Mono<Boolean> existsByPhone(String phone);


}
