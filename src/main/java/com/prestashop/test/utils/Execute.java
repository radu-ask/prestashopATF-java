package com.prestashop.test.utils;

import java.util.function.Supplier;

public final class Execute {

    public static <T> void withRetry(Supplier<T> function){
        withRetry(Constants.MAX_RETRIES, function);
    }

    public static <T> void withRetry(int maxRetries, Supplier<T> function) {
        int attempt = 0;
        Exception lastException = null;
        while (attempt++ < maxRetries) {
            try {
                function.get();
                return;
            } catch (Exception e) {
                lastException = e;
                System.err.println("FAILED - on attempt " + attempt + " out of " + maxRetries);
                e.printStackTrace();
                if (attempt >= maxRetries) break;
            }
        }
        throw lastException != null ?
                ((RuntimeException) lastException) :
                new RuntimeException(lastException);
    }

    //TODO: implement retry function for exceptions
}
