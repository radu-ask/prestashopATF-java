package com.prestashop.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends AbstractBasePage{
    private WebDriver driver;
    private String baseUrl = "http://localhost/prestashop/en/";

    @FindBy(how = How.XPATH, using = "xpath")
    private WebElement element;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        driver.get(baseUrl);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
