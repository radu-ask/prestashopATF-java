package com.prestashop.domain.pages;

import com.prestashop.domain.pages.base.AbstractBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractBasePage {
    static final Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(){

    }
}
