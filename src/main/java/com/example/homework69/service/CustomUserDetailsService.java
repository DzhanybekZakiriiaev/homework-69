package com.example.homework69.service;

import com.example.homework69.details.CustomUserDetails;
import com.example.homework69.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        user = userService.findByEmail(email).get(0);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}