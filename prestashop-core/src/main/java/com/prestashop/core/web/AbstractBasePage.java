package com.prestashop.core.web;

import com.prestashop.core.utils.Constants;
import com.prestashop.core.utils.Execute;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class AbstractBasePage {
    static final Logger logger = Logger.getLogger(AbstractBasePage.class.getName());
    protected WebDriver driver;
    private WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Constants.MAX_WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.MAX_WAIT_TIME), this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
