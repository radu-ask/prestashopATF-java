package com.prestashop.domain.pages;

import com.prestashop.core.web.element.ElementFactory;
import com.prestashop.core.web.widgets.CheckBox;
import com.prestashop.core.web.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothesPage extends WebBasePage {
    public ClothesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"checkbox\"]")
    private WebElement checkboxMen;

    public CheckBox getCheckboxMen() {
        return ElementFactory.getAsCheckBox(checkboxMen);
    }
}
