package com.prestashop.core.web;

import com.prestashop.core.utils.Constants;
import com.prestashop.core.utils.ThreadUtil;
import com.prestashop.core.utils.logger.LogUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public abstract class WebBasePage {
    protected WebDriver driver;
    private final Logger logger = LogUtil.getInstance();

    public WebBasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Constants.MAX_WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.MAX_WAIT_TIME), this);
        logger.info("On the " + ThreadUtil.getCurrentClassName());

    }

    public String getTitle() {
        return driver.getTitle();
    }
}
