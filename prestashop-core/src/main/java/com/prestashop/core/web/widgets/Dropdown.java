package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

import java.util.List;

public interface Dropdown extends Element {

    String getSelectedOption();

    void selectByText(String value);

    List<String> getValues();

    boolean isOptionSelected(String value);

    void selectByIndex(int index);
}
