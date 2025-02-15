package com.example.homework69.service;

import com.example.homework69.dto.UserRegistrationDto;
import com.example.homework69.entity.User;
import com.example.homework69.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public List<User> findByEmail(String email) {
        return userRepository.findAllUserByEmail(email);
    }

    public List<User> findByName(String name) {
        return userRepository.findAllUserByName(name);
    }

    public List<User> findByUsername(String username) {
        return userRepository.findAllUserByUsername(username);
    }

    public void registerUser(UserRegistrationDto registrationDto) {
        User user = User.builder()
                .name(registrationDto.getName())
                .email(registrationDto.getEmail())
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .build();
        userRepository.save(user);
    }
}
