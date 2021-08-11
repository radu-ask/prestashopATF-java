package com.prestashop.domain.pages.components;

import com.prestashop.core.web.WebBasePage;
import com.prestashop.core.web.element.ElementFactory;
import com.prestashop.core.web.widgets.TextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends WebBasePage {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='_desktop_logo']/a")
    private WebElement logo;

    @FindBy(xpath = "//*[@id='category-3']/a")
    private WebElement menuItemClothes;

    @FindBy(xpath = "//*[@id='category-6']/a")
    private WebElement menuItemAccessories;

    @FindBy(xpath = "//*[@id='category-9']/a")
    private WebElement menuItemArt;

    @FindBy(xpath = "//*[@placeholder='Search our catalog']")
    private WebElement textBoxSearch;

    @FindBy(xpath = "//*[@id='search_widget']/form/button")
    private WebElement buttonSearch;

    public void searchFor(String item) {
        getTextboxSearch().setText(item);
        buttonSearch.click();
    }

    public TextBox getTextboxSearch() {
        return ElementFactory.getAsTextBox(textBoxSearch);
    }

    public WebElement getLogo() {
        return logo;
    }
}
