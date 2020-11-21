package com.prestashop.test.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private String baseUrl = "http://localhost/prestashop/en/";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
        driver.get(baseUrl);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
