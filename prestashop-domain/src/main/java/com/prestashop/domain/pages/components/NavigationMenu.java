package com.prestashop.domain.pages.components;

import com.prestashop.core.web.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends AbstractBasePage {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='_desktop_logo']/a")
    WebElement logo;

    @FindBy(xpath = "//*[@id='category-3']/a")
    WebElement menuItemClothes;

    @FindBy(xpath = "//*[@id='category-6']/a")
    WebElement menuItemAccessories;

    @FindBy(xpath = "//*[@id='category-9']/a")
    WebElement menuItemArt;

    @FindBy(xpath = "//*[@placeholder='Search our catalog']")
    WebElement textboxSearch;

    @FindBy(xpath = "//*[@id='search_widget']/form/button")
    WebElement buttonSearch;

    public void searchFor(String item) {
        setElementText(textboxSearch, item);
        buttonSearch.click();
    }

    public WebElement getTextboxSearch() {
        return textboxSearch;
    }
}
