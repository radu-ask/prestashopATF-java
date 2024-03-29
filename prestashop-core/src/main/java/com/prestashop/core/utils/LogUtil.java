package com.prestashop.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogUtil {
    private LogUtil(){}

    public static Logger getInstance(){
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(className);
    }
}
