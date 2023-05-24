package com.example.homework69.util;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator {
    private static final int TOKEN_LENGTH = 32;

    public static String generateRandomToken() {
        byte[] randomBytes = new byte[TOKEN_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}
