package com.prestashop.domain.pages.components;

import com.prestashop.core.web.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopHeader extends WebBasePage {

    @FindBy(xpath = "//*[@id='contact-link']/a")
    private WebElement linkContactUs;

    @FindBy(xpath = "//*[@aria-label='Language dropdown']")
    private WebElement dropdownLanguage;

    @FindBy(xpath = "//*[@title='Log in to your customer account']")
    private WebElement linkSignIn;

    @FindBy(xpath = "//*[@id='_desktop_cart']//child::span[contains(text(), 'Cart')]")
    private WebElement cart;

    public TopHeader(WebDriver driver) {
        super(driver);
    }

    public void clickContactUsLink(){
        linkContactUs.click();
    }
}
