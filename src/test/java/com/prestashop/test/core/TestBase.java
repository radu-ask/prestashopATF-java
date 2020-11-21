package com.prestashop.test.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverFactory driverFactory = new WebDriverFactory();
        driver = driverFactory.getDriver(BrowserType.CHROME);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
