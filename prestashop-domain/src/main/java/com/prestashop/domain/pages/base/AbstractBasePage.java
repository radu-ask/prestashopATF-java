package com.prestashop.domain.pages.base;

import com.prestashop.core.utils.Constants;
import com.prestashop.core.utils.Execute;
import com.prestashop.domain.pages.components.NavigationMenu;
import com.prestashop.domain.pages.components.TopHeader;
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
    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constants.MAX_WAIT_TIME);
        driver.manage().timeouts().implicitlyWait(Constants.MAX_WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.MAX_WAIT_TIME), this);
    }

    public void deleteTextFromElement(WebElement element) {
        element.clear();
    }

    public void setElementText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        deleteTextFromElement(element);
        element.sendKeys(text);
        logger.info("Text: <" + text + "> was set successfully.");
    }

    public void setElementTextWithRetry(WebElement element, String text) {
        Execute.withRetry(() -> {
            setElementText(element, text);
            if (!element.getAttribute("value").equals(text)) {
                throw new IllegalStateException(
                        "The text was not set successfully in the element: " + element.toString());
            }
            return null;
        });
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
