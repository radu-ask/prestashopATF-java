package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

public interface RadioButton extends Element {

    void select();

    boolean isSelected();

    String getValue();
}
