package com.prestashop.core.utils;

public class ThreadUtil {

    private ThreadUtil(){
    }

    public static String getCurrentClassName(){
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
