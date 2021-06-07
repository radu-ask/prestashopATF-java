package com.prestashop.core.utils;

import java.util.concurrent.atomic.AtomicLong;

public class DateTimeUtil {

    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    private DateTimeUtil() {
    }

    private static long getUniqueCurrentTimeMS() {
        long now = System.currentTimeMillis();
        while(true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime+1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return now;
        }
    }

    public static String generateUniqueTimeStamp(String input){
        return input + getUniqueCurrentTimeMS();
    }
}
