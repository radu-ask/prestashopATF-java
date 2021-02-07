package com.prestashop.core.web.factory;

import com.prestashop.core.web.element.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.prestashop.core.web.factory.ImplementedByProcessor.getWrapperClass;

/**
 * Wraps a list of WebElements in multiple wrapped elements.
 */
public class ElementListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<?> wrappingType;

    /**
     * Given an interface and a locator, apply a wrapper over a list of elements.
     *
     * @param interfaceType Interface type we're trying to wrap around the element.
     * @param locator Locator on the page for the elements.
     * @param <T> Type of the interface.
     */
    public <T> ElementListHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if(!Element.class.isAssignableFrom(interfaceType)){
            throw new RuntimeException("Interface not assignable to Element.");
        }
        this.wrappingType = getWrapperClass(interfaceType);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<Object> wrappedList = new ArrayList<Object>();
        Constructor<?> constructor = wrappingType.getConstructor(WebElement.class);
        for(WebElement element : locator.findElements()){
            Object thing = constructor.newInstance(element);
            wrappedList.add(wrappingType.cast(thing));
        }
        try {
            return method.invoke(wrappedList, objects);
        }catch (InvocationTargetException exception){
            throw exception.getCause();
        }
    }
}
