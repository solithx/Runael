package com.runael.user.controller;

import com.runael.user.dto.UserCreateRequest;
import com.runael.user.dto.UserUpdateRequest;
import com.runael.user.dto.UserResponse;
import com.runael.user.mapper.UserMapper;
import com.runael.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Flux<UserResponse> getAllUsers() {
        return userService.getAllUsers().map(UserMapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserResponse>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id).map(UserMapper::toResponse).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<UserResponse>> createUser(
            @RequestBody @Valid UserCreateRequest request) {
        return userService.createUser(UserMapper.toEntity(request)).map(UserMapper::toResponse)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserResponse>> updateUser(@PathVariable Long id,
            @RequestBody @Valid UserUpdateRequest request) {
        return userService.updateUser(id, UserMapper.toEntity(request)).map(UserMapper::toResponse)
                .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id).thenReturn(ResponseEntity.noContent().build());
    }

    @GetMapping("/email/{email}")
    public Mono<ResponseEntity<UserResponse>> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email).map(UserMapper::toResponse).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/phone/{phone}")
    public Mono<ResponseEntity<UserResponse>> getUserByPhone(@PathVariable String phone) {
        return userService.getUserByPhone(phone).map(UserMapper::toResponse).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
