package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

public interface Checkbox extends Element{

    void toggle();

    void check();

    boolean isChecked();
}
