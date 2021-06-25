package com.prestashop.core.web;

import com.prestashop.core.utils.DateTimeUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class WebDriverUtil {

    private static final String SCREENSHOT_EXTENSION = ".png";

    public static String takeScreenshot(WebDriver driver, ITestResult iTestResult){
        String testName = iTestResult.getMethod().getMethodName();
        String screenshotName = DateTimeUtil.generateUniqueTimeStamp(testName) + SCREENSHOT_EXTENSION;
        String defaultLocation = System.getProperty("user.dir") + "\\output\\screenshots";
        return takeScreenshot(driver, defaultLocation, screenshotName);
    }

    private static String takeScreenshot(WebDriver driver, String location, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File outputFile = new File(location, screenshotName);
        try {
            FileUtils.copyFile(srcFile, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile.getAbsolutePath();
    }
}
