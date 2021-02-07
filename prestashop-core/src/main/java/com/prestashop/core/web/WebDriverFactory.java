package com.prestashop.core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getDriver(WebBrowserType webBrowserType) {
        WebDriver driver = null;
        try {
            switch (webBrowserType) {
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
                    throw new IllegalArgumentException(String.format("Browser %s doesn't exist!", webBrowserType.toString()));
            }
        } catch (Exception e) {
            System.out.println("Unable to load driver: " + e.getMessage());
        }
        return driver;
    }
}
