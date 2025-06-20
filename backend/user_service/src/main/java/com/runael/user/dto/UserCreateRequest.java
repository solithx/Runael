package com.runael.user.dto;

import com.runael.user.model.Gender;
import jakarta.validation.constraints.*;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateRequest {

    @NotBlank(message = "Имя обязательно")
    private String firstName;

    @NotBlank(message = "Фамилия обязательна")
    private String lastName;

    @NotBlank(message = "Телефон обязателен")
    @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Неверный формат телефона")
    private String phone;

    @NotBlank(message = "Email обязателен")
    @Email(message = "Неверный email")
    private String email;

    private String city;

    private Gender gender;

    private LocalDate birthDate;

    private String avatarUrl;

    private String bio;
}
