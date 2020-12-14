package com.prestashop.domain.pages.components;

import com.prestashop.domain.pages.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends AbstractBasePage {

    @FindBy(xpath = "//*[@id='_desktop_logo']/a")
    private WebElement logo;

    @FindBy(xpath = "//*[@id='category-3']/a")
    private WebElement menuItemClothes;

    @FindBy(xpath = "//*[@id='category-6']/a")
    private WebElement menuItemAccessories;

    @FindBy(xpath = "//*[@id='category-9']/a")
    private WebElement menuItemArt;

    @FindBy(xpath = "//*[@placeholder='Search our catalog']")
    private WebElement textboxSearch;

    @FindBy(xpath = "//*[@id='search_widget']/form/button")
    private WebElement buttonSearch;

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String item) {
        setElementText(textboxSearch, item);
        buttonSearch.click();
    }
}
