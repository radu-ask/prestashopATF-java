package com.prestashop.tests.core;

import com.prestashop.core.utils.LogUtil;
import com.prestashop.core.web.WebBrowserType;
import com.prestashop.core.web.WebDriverFactory;
import com.prestashop.domain.core.PrestashopApplication;
import com.prestashop.domain.pages.HomePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    private final Logger logger = LogUtil.getInstance();
    private WebDriver driver;
    private PrestashopApplication prestashopApplication;

    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver(WebBrowserType.CHROME);
        prestashopApplication = new PrestashopApplication(driver);
    }

    @AfterTest
    public void afterTest(){
        if (driver != null){
            try {
                driver.quit();
            }catch (Exception e){
                logger.error("Failed to quit the driver!");
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage goToHomePage() {
        return new HomePage(driver);
    }

    public PrestashopApplication getApp(){
        return prestashopApplication;
    }
}
