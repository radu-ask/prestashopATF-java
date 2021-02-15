package com.prestashop.core.web.widgets;

import com.prestashop.core.web.element.Element;

public interface Textbox extends Element {

    void setText(String value);

    void setTextWithRetry(String value);
}
