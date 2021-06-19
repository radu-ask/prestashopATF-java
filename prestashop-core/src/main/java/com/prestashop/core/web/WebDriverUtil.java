package com.prestashop.core.web;

import com.prestashop.core.utils.DateTimeUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class WebDriverUtil {

    public static String takeScreenshotAndStoreIt(WebDriver driver){
        String defaultLocation = System.getProperty("user.dir") + "\\output\\screenshots";
        return takeScreenshotAndStoreIt(driver, defaultLocation);
    }

    private static String takeScreenshotAndStoreIt(WebDriver driver, String location) {
        String screenshotName = DateTimeUtil.generateUniqueTimeStamp("ss") + ".png";
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
