package com.prestashop.core.web.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable {
    /**
     * Returns true when the inner element is ready to be used
     *
     * @return boolean true for an initialized WebElement, or false if we somehow passed a null WebElement.
     */
    boolean elementWired();
}
