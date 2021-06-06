package com.prestashop.core.web.widgets;

import com.prestashop.core.utils.Execute;
import com.prestashop.core.web.element.ElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBoxImpl extends ElementImpl implements TextBox {

    public TextBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void setText(String value) {
        getWait().until(ExpectedConditions.elementToBeClickable(getElement()));
        getElement().clear();
        getElement().sendKeys(value);
    }

    @Override
    public void setTextWithRetry(String value) {
        Execute.withRetry(() -> {
            setText(value);
            if (!getElement().getAttribute("value").equals(value)) {
                throw new IllegalStateException(
                        "The text was not set successfully in the element: " + getElement().toString());
            }
            return null;
        });
    }
}
