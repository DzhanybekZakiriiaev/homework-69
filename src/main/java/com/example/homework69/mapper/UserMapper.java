package com.example.homework69.mapper;


import com.example.homework69.dto.UserDto;
import com.example.homework69.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
