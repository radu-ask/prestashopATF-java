package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

public interface CheckBox extends Element{

    void toggle();

    void check();

    boolean isChecked();
}
