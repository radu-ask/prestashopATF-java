package com.prestashop.core.web.element;

import com.prestashop.core.web.widgets.*;
import org.openqa.selenium.WebElement;

public class ElementFactory {
    public static CheckBox getAsCheckBox(WebElement element){
        return new CheckBoxImpl(element);
    }

    public static Dropdown getAsDropdown(WebElement element){
        return new DropdownImpl(element);
    }

    public static RadioButton getAsRadiobutton(WebElement element){
        return new RadioButtonImpl(element);
    }

    public static TextBox getAsTextBox(WebElement element){
        return new TextBoxImpl(element);
    }

}
