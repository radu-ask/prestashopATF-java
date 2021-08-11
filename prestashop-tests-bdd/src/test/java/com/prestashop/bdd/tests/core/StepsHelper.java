package com.prestashop.bdd.tests.core;

import com.prestashop.domain.core.PrestashopApplication;
import com.prestashop.domain.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class StepsHelper {
    private WebDriver driver;
    private PrestashopApplication prestashopApplication;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public PrestashopApplication getApp(){
        return prestashopApplication;
    }

    public void setApp(PrestashopApplication prestashopApplication){
        this.prestashopApplication = prestashopApplication;
    }
}
