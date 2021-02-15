package com.prestashop.domain.pages;

import com.prestashop.core.web.element.ElementFactory;
import com.prestashop.core.web.widgets.Checkbox;
import com.prestashop.core.web.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothesPage extends AbstractBasePage {

    public ClothesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"checkbox\"]")
    private WebElement checkboxMen;

    public Checkbox getCheckboxMen() {
        return ElementFactory.getAsCheckbox(checkboxMen);
    }
}
