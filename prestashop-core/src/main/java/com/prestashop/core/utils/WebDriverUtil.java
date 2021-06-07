package com.prestashop.core.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class WebDriverUtil {

    public static void takeScreenShotAndStoreIt(WebDriver driver){
        String defaultLocation = System.getProperty("user.dir") + "\\output\\screenshots";
        try {
            takeScreenShotAndStoreIt(driver, defaultLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void takeScreenShotAndStoreIt(WebDriver driver, String location) throws IOException {
        String screenshotName = DateTimeUtil.generateUniqueTimeStamp("ss") + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File outputFile = new File(location, screenshotName);
        FileUtils.copyFile(srcFile, outputFile);
    }
}
