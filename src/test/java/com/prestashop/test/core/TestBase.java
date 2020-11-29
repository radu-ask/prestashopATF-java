package com.prestashop.test.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver(BrowserType.CHROME);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
