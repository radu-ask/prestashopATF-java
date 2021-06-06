package com.prestashop.core.web;

import com.prestashop.core.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBasePage {
    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Constants.MAX_WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.MAX_WAIT_TIME), this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
