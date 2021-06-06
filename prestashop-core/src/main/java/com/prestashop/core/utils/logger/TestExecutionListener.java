package com.prestashop.core.utils.logger;

import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TestExecutionListener implements IInvokedMethodListener {

    private static final Logger logger = LogUtil.getInstance();
    private final Map<Integer, Deque<String>> logsMap = new HashMap<Integer, Deque<String>>();

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
