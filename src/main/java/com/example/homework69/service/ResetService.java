package com.example.homework69.service;

import com.example.homework69.mapper.UserMapper;
import com.example.homework69.util.TokenGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@AllArgsConstructor
public class ResetService {

    private final UserService userService;

    public String initiatePasswordReset(String email, String token, String password) {
        if (userService.findByEmail(email).get(0).getToken().equals(token)){
            userService.findByEmail(email).get(0).setPassword(password);
        }
        return "redirect:/login";
    }

    public String showPasswordResetPage(Model model, String email) {
        String token = TokenGenerator.generateRandomToken();
        String hashedToken = hashToken(token);
        userService.findByEmail(email).get(0).setToken(token);
        model.addAttribute("hashedToken", hashedToken);
        return "password-reset";
    }

    private String hashToken(String token) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(token.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing token: " + e.getMessage());
        }
    }
}
