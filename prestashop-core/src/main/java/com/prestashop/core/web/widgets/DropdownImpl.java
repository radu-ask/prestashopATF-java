package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;
import com.prestashop.core.web.element.ElementImpl;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownImpl extends ElementImpl implements Dropdown {

    public DropdownImpl(WebElement element) {
        super(element);
    }

    @Override
    public String getSelectedOption() {
        return null;
    }

    @Override
    public void selectByText(String value) {

    }

    @Override
    public List<String> getValues() {
        return null;
    }

    @Override
    public boolean isOptionSelected(String value) {
        return false;
    }

    @Override
    public void selectByIndex(int index) {

    }
}
