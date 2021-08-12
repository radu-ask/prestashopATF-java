package com.prestashop.core.web.element;

import com.prestashop.core.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementImpl implements Element {
    private final WebElement element;

    public ElementImpl(WebElement element) {
        this.element = element;
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public WebDriver getDriver() {
        return ((RemoteWebElement)element).getWrappedDriver();
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void clickAndWait() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void hover() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    @Override
    public WebElement unwrap() {
        return getElement();
    }

    protected WebElement getElement(){
        return element;
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Constants.MAX_WAIT_TIME);
    }
}
