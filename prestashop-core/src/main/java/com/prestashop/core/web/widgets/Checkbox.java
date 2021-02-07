package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;
import com.prestashop.core.web.element.ImplementedBy;

@ImplementedBy(CheckboxImpl.class)
public interface Checkbox extends Element{

    void toggle();

    void check();

    boolean isChecked();
}
