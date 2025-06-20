package com.runael.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.runael.user.model.Gender;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private Gender gender;
    private LocalDate birthDate;
    private String avatarUrl;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
