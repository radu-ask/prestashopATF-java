package com.prestashop.domain.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;
    private final int defaultMaxWaitTime = 20;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, defaultMaxWaitTime);
        driver.manage().timeouts().implicitlyWait(defaultMaxWaitTime, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void deleteTextFromElement(WebElement element) {
        element.clear();
    }

    public void setElementText(WebElement element, String text) {
        deleteTextFromElement(element);
        element.sendKeys(text);
    }
}
