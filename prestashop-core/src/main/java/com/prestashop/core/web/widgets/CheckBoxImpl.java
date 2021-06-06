package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.ElementImpl;
import org.openqa.selenium.WebElement;

public class CheckBoxImpl extends ElementImpl implements CheckBox {

    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void toggle() {
        getElement().click();
    }

    @Override
    public void check() {
        if(isChecked()) toggle();
    }

    @Override
    public boolean isChecked() {
        return getElement().isSelected();
    }
}
