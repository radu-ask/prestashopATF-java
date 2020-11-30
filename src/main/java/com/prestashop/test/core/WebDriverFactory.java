package com.prestashop.test.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
        throw new IllegalStateException("WebDriverFactory class cannot be instantiated!");
    }

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = null;
        try {
            switch (browserType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Browser %s doesn't exist!", browserType.toString()));
            }
        } catch (Exception e) {
            System.out.println("Unable to load driver: " + e.getMessage());
        }
        return driver;
    }
}
