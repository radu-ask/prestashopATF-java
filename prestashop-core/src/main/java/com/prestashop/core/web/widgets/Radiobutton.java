package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

public interface Radiobutton extends Element {

    void select();

    boolean isSelected();

    String getValue();
}
