package com.example.homework69.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserDto {
    private String name;
    private String email;
    private String username;
}
