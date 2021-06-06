package com.prestashop.domain.pages;

import com.prestashop.core.web.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ClothesPage clickOnClothesLink(){
        WebElement link = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        link.click();
        return new ClothesPage(driver);
    }
    public void login(){
        //TODO: implement logger in the project
        // Add dependency*
        // Create properties file*
        // Create Listener
        // Generate testng.xml file for listener

    }

}
