package com.prestashop.test.utils;

import java.util.Arrays;
import java.util.function.Supplier;

public final class Execute {

    public static <T> T withRetry(Supplier<T> function, Supplier<Boolean> exitCondition) {
        return withRetry(Constants.MAX_RETRIES, function, exitCondition);
    }

    public static <T> T withRetry(int maxRetries, Supplier<T> function, Supplier<Boolean> exitCondition) {
        int attempt = 0;
        while (attempt++ < maxRetries) {
            T result = function.get();
            if (exitCondition.get()) return result;
            if (attempt >= maxRetries) break;
        }
        throw new RuntimeException("Exit condition not satisfied! Total attempts: " + attempt);
    }

    public static <T> T withRetry(Supplier<T> function) {
        return withRetry(Constants.MAX_RETRIES, function);
    }

    public static <T> T withRetry(int maxRetries, Supplier<T> function) {
        int attempt = 0;
        Exception lastException = null;
        while (attempt++ < maxRetries) {
            try {
                return function.get();
            } catch (Exception e) {
                lastException = e;
                System.err.println("\nFAILED - on attempt " + attempt + " out of " + maxRetries);
                e.printStackTrace();
                if (attempt >= maxRetries) break;
                DateTimeUtil.wait(500 * attempt);
            }
        }
        throwLastException(lastException);
        return null;
    }

    public static <T> T withRetryForExceptions(
            Supplier<T> function,
            Class<? extends Exception>... exceptionsToCatch) {
        return withRetryForExceptions(Constants.MAX_RETRIES, function, exceptionsToCatch);
    }

    public static <T> T withRetryForExceptions(
            int maxRetries,
            Supplier<T> function,
            Class<? extends Exception>... exceptionsToCatch) {

        exceptionsToCatch = exceptionsToCatch.length == 0 ?
                new Class[]{Exception.class} :
                exceptionsToCatch;
        int attempt = 0;
        Exception lastException = null;
        while (attempt++ < maxRetries) {
            try {
                return function.get();
            } catch (Exception e) {
                lastException = e;
                if (Arrays.stream(exceptionsToCatch)
                        .noneMatch(toCatch -> toCatch.isAssignableFrom(e.getClass()))) {
                    throwLastException(lastException);
                } else {
                    System.err.println("\nFAILED - on attempt " + attempt + " out of " + maxRetries);
                    e.printStackTrace();
                    if (attempt >= maxRetries) break;
                    DateTimeUtil.wait(500 * attempt);
                }
            }
        }
        throwLastException(lastException);
        return null;
    }

    private static void throwLastException(Exception lastException) {
        throw lastException != null ?
                ((RuntimeException) lastException) :
                new RuntimeException(lastException);
    }
}
