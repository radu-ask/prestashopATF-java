package com.prestashop.core.web.factory;

import com.prestashop.core.web.element.Element;
import com.prestashop.core.web.element.ImplementedBy;

/**
 * Processes the interface type into a useful class reference for wrapping WebElements.
 */
public final class ImplementedByProcessor {

    private ImplementedByProcessor() {
    }

    /**
     * Gets the wrapper class (descended from ElementImpl) for the annotation @ImplementedBy.
     *
     * @param theInterface interface to process for annotations
     * @param <T> type of the wrapped class
     * @return class name of the class in question
     */
    public static <T> Class<?> getWrapperClass(Class<?> theInterface) {
        if (theInterface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = theInterface.getAnnotation(ImplementedBy.class);
            Class<?> theClass = annotation.value();
            if (Element.class.isAssignableFrom(theClass)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " +
                theInterface.getCanonicalName() + " if you want to extend.");
    }
}
