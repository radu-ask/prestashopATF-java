package com.prestashop.tests;

import com.prestashop.core.web.WebBrowserType;
import com.prestashop.core.web.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver(WebBrowserType.CHROME);
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
