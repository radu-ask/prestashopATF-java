package com.prestashop.core.web;

import org.openqa.selenium.WebDriver;

public class WebApplication {
    public WebDriver driver;

    public WebApplication(WebDriver webDriver) {
        this.driver = webDriver;
    }
}
