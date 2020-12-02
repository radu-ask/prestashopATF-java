package com.prestashop.core.utils;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.OptionalInt;

public class RandomUtil {

    private RandomUtil(){
        throw new IllegalStateException("Cannot instantiate RandomUtil class!");
    }

    public static int getRandomNumberInRange(int min, int max){
        final SecureRandom random = new SecureRandom();
        return random.ints(min, max).limit(1).findFirst().getAsInt();
    }
}
