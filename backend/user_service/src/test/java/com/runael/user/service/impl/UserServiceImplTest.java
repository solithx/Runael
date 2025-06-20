package com.runael.user.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.runael.user.model.User;
import com.runael.user.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Максат");

        when(userRepository.findById(1L)).thenReturn(Mono.just(user));

        StepVerifier.create(userService.getUserById(1L))
                .expectNextMatches(u -> u.getFirstName().equals("Максат")).verifyComplete();
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setFirstName("Максат");

        when(userRepository.save(user)).thenReturn(Mono.just(user));

        StepVerifier.create(userService.createUser(user))
                .expectNextMatches(u -> u.getFirstName().equals("Максат")).verifyComplete();
    }

    @Test
    void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setFirstName("Старое имя");

        User updatedUser = new User();
        updatedUser.setFirstName("Новое имя");

        when(userRepository.findById(1L)).thenReturn(Mono.just(existingUser));
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(userService.updateUser(1L, updatedUser))
                .expectNextMatches(u -> u.getFirstName().equals("Новое имя")).verifyComplete();
    }

    @Test
    void testDeleteUser() {
        when(userRepository.deleteById(1L)).thenReturn(Mono.empty());

        StepVerifier.create(userService.deleteUser(1L)).verifyComplete();
    }

    @Test
    void testExistsByEmail() {
        String email = "test@example.com";
        when(userRepository.existsByEmail(email)).thenReturn(Mono.just(true));

        StepVerifier.create(userService.existsByEmail(email)).expectNext(true).verifyComplete();
    }

    @Test
    void testExistsByPhone() {
        String phone = "+77001234567";
        when(userRepository.existsByPhone(phone)).thenReturn(Mono.just(false));

        StepVerifier.create(userService.existsByPhone(phone)).expectNext(false).verifyComplete();
    }

    @Test
    void testGetUserByEmail() {
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Mono.just(user));

        StepVerifier.create(userService.getUserByEmail(email))
                .expectNextMatches(u -> u.getEmail().equals(email)).verifyComplete();
    }

    @Test
    void testGetUserByPhone() {
        String phone = "+77001234567";
        User user = new User();
        user.setPhone(phone);

        when(userRepository.findByPhone(phone)).thenReturn(Mono.just(user));

        StepVerifier.create(userService.getUserByPhone(phone))
                .expectNextMatches(u -> phone.equals(u.getPhone())).verifyComplete();
    }



}
