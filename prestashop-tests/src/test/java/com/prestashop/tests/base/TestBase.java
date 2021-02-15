package com.prestashop.tests.base;

import com.prestashop.core.web.WebBrowserType;
import com.prestashop.core.web.WebDriverFactory;
import com.prestashop.domain.base.PrestashopApplication;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private WebDriver driver;
    private PrestashopApplication prestashopApplication;

    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver(WebBrowserType.CHROME);
        prestashopApplication = new PrestashopApplication(driver);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public PrestashopApplication getPrestashopApplication() {
        return prestashopApplication;
    }
}
