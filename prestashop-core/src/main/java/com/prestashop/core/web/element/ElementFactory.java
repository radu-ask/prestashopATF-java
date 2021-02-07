package com.prestashop.core.web.element;

import com.prestashop.core.web.widgets.Checkbox;
import com.prestashop.core.web.widgets.CheckboxImpl;
import org.openqa.selenium.WebElement;

public class ElementFactory {

    public static Checkbox getAsCheckbox(WebElement element){
        return new CheckboxImpl(element);
    }
}
