package com.prestashop.tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import com.prestashop.core.utils.logger.LogUtil;
import com.prestashop.core.web.WebDriverUtil;
import com.prestashop.tests.base.utils.ExtentReportsUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

public class TestProgressListener implements ITestListener {

    private static final Logger logger = LogUtil.getInstance();
    private final ExtentReports extentReports = ExtentReportsUtil.getInstance();
    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " started.");
        logger.info("Description: " + iTestResult.getMethod().getDescription());

        ExtentTest currentTest = extentReports.createTest(getTestName(iTestResult));
        extentTest.set(currentTest);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " passed.");

        Markup markup = ExtentReportsUtil.getTestPassedSuccessfullyMarkup(iTestResult);
        extentTest.get().log(Status.PASS, markup);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Failed with exception: " + iTestResult.getThrowable());
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((TestBase)currentClass).getDriver();
        String screenshotPath = null;
        if(driver != null){
            screenshotPath = WebDriverUtil.takeScreenshotAndStoreIt(driver);
        }else{
            logger.error("Failed to take a screenshot. The driver was null.");
        }

        String extentLogMessage = ExtentReportsUtil.getTestFailMessageForExtentReport(iTestResult);
        extentTest.get().fail(extentLogMessage);

        try {
            Media media = MediaEntityBuilder.createScreenCaptureFromPath(Objects.requireNonNull(screenshotPath)).build();
            extentTest.get().fail("<b><font color=orange>See screenshot.</font></b>", media);
        }catch (Exception e){
            extentTest.get().fail("<b><font color=red>Failed to attach the screenshot.</font></b>");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Skipped with exception: " + iTestResult.getThrowable());

        Markup markup = ExtentReportsUtil.getTestSkippedMarkup(iTestResult);
        extentTest.get().log(Status.SKIP, markup);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Failed within success percentage with exception: " + iTestResult.getThrowable());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("==== starting " + iTestContext.getName() + "====");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("==== finished " + iTestContext.getName() + "====");
        extentReports.flush();
    }

    private static String getTestName(ITestResult iTestResult){
        return iTestResult.getTestClass().getName() + "_" + iTestResult.getMethod().getMethodName();
    }
}
