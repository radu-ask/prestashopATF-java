package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.ElementImpl;
import org.openqa.selenium.WebElement;

public class RadioButtonImpl extends ElementImpl implements RadioButton {

    public RadioButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void select() {

    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public String getValue() {
        return null;
    }
}
