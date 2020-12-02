package com.prestashop.core.utils;

public class DateTimeUtil {

    private DateTimeUtil(){
        throw new IllegalStateException("Cannot instantiate DateTimeUtil class!");
    }

    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
