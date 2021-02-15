package com.prestashop.core.web;

import org.openqa.selenium.WebDriver;

public class WebApplication {
    private WebDriver driver;

    public WebApplication(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
