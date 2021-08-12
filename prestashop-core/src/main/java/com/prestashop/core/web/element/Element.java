package com.prestashop.core.web.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Element{
    String getText();

    boolean isDisplayed();

    boolean isEnabled();

    WebDriver getDriver();

    WebElement unwrap();

    void click();

    void clickAndWait();

    void hover();
}
