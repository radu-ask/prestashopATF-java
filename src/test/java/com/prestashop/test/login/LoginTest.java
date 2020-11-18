package com.prestashop.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    public String baseUrl = "http://localhost/prestashop/en/";
    public String driverPath = "C:\\Users\\gorea\\prestashopATF-java\\src\\main\\resources\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void setBaseUrl(){
        System.out.println("Starting chromedriver");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomePageTitle(){
        String expectedTitle = "OLSO";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterTest
    public void disposeDriver(){
        driver.quit();
    }
}
