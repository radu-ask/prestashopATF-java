package com.prestashop.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {
    private String baseUrl = "http://localhost/prestashop/en/";

    @FindBy(xpath = "xpath")
    private WebElement element;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(baseUrl);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
