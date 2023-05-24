package com.example.homework69.controller;

import com.example.homework69.service.ResetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ResetController {

    private final ResetService resetService;

    @PostMapping("/password-reset")
    public String initiatePasswordReset(@RequestParam("email") String email, @RequestParam("token") String token, @RequestParam("password") String password) {
        return resetService.initiatePasswordReset(email, token, password);
    }

    @GetMapping("/password-reset/email")
    public String showPasswordResetPage(Model model, @PathVariable String email) {
        return resetService.showPasswordResetPage(model, email);
    }
}
