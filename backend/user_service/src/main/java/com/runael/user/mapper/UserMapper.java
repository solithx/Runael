package com.runael.user.mapper;

import com.runael.user.dto.*;
import com.runael.user.model.User;

public class UserMapper {

    public static User toEntity(UserCreateRequest dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());
        user.setGender(dto.getGender());
        user.setBirthDate(dto.getBirthDate());
        user.setAvatarUrl(dto.getAvatarUrl());
        user.setBio(dto.getBio());
        return user;
    }

    public static User toEntity(UserUpdateRequest dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());
        user.setGender(dto.getGender());
        user.setBirthDate(dto.getBirthDate());
        user.setAvatarUrl(dto.getAvatarUrl());
        user.setBio(dto.getBio());
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhone(user.getPhone());
        response.setEmail(user.getEmail());
        response.setCity(user.getCity());
        response.setGender(user.getGender());
        response.setBirthDate(user.getBirthDate());
        response.setAvatarUrl(user.getAvatarUrl());
        response.setBio(user.getBio());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
