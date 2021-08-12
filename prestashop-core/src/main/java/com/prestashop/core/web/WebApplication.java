package com.prestashop.core.web;

import com.prestashop.core.utils.DateTimeUtil;
import org.openqa.selenium.WebDriver;

public class WebApplication {
    private final WebDriver driver;

    public WebApplication(WebDriver webDriver, String applicationUrl) {
        this.driver = webDriver;
        webDriver.get(applicationUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
