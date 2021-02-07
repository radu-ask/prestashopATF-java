package com.prestashop.core.web.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * An implementation of the Element interface. It delegates its work to an underlying WebElement instance
 * for custom functionality.
 */
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
    public WebElement unwrap() {
        return element;
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

    public WebElement getElement(){
        return element;
    }
}
