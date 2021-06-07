package com.prestashop.tests.core;

import com.prestashop.core.utils.logger.LogUtil;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestExecutionListener implements IInvokedMethodListener {

    private static final Logger logger = LogUtil.getInstance();

    // TODO: running tests
    //  run multiple tests in parallel
    //  find a way to output logging separately for each test

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
