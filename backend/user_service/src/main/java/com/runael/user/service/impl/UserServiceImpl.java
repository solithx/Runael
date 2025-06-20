package com.runael.user.service.impl;

import com.runael.user.model.User;
import com.runael.user.repository.UserRepository;
import com.runael.user.service.UserService;

import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Mono<User> createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return checkUniqueFields(user, null).then(userRepository.save(user));
    }

    private Mono<Void> checkUniqueFields(User user, Long excludeId) {
        return userRepository.findByPhone(user.getPhone())
                .filter(existing -> !existing.getId().equals(excludeId))
                .flatMap(existing -> Mono
                        .error(new IllegalStateException("Номер телефона уже занят")))
                .switchIfEmpty(
                        userRepository.findByEmail(user.getEmail())
                                .filter(existing -> !existing.getId().equals(excludeId))
                                .flatMap(existing -> Mono
                                        .error(new IllegalStateException("Email уже занят"))))
                .then(); // Преобразуем Mono<User> в Mono<Void>
    }


    @Override
    public Mono<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalStateException("Пользователь не найден")))
                .flatMap(existingUser -> checkUniqueFields(updatedUser, id).then(Mono.defer(() -> {
                    // Обновляем поля
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    existingUser.setPhone(updatedUser.getPhone());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setCity(updatedUser.getCity());
                    existingUser.setGender(updatedUser.getGender());
                    existingUser.setBirthDate(updatedUser.getBirthDate());
                    existingUser.setAvatarUrl(updatedUser.getAvatarUrl());
                    existingUser.setBio(updatedUser.getBio());
                    existingUser.setUpdatedAt(LocalDateTime.now());
                    return userRepository.save(existingUser);
                })));
    }



    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Mono<Boolean> existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
