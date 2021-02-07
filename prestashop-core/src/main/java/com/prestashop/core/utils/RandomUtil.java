package com.prestashop.core.utils;

import java.security.SecureRandom;

public class RandomUtil {

    private RandomUtil() {
    }

    public static int getRandomNumberInRange(int min, int max) {
        final SecureRandom random = new SecureRandom();
        return random.ints(min, max).limit(1).findFirst().getAsInt();
    }
}
