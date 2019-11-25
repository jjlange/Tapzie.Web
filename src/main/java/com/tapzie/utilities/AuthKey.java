package com.tapzie.utilities;

import java.security.SecureRandom;

public class AuthKey {
    public static String create() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }
}
