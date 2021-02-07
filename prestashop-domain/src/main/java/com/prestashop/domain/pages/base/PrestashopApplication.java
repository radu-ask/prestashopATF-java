package com.prestashop.domain.pages.base;

import com.prestashop.core.web.WebApplication;
import com.prestashop.domain.pages.HomePage;
import com.prestashop.domain.pages.components.NavigationMenu;
import com.prestashop.domain.pages.components.TopHeader;
import org.openqa.selenium.WebDriver;

public class PrestashopApplication extends WebApplication {
    private static final String URL = "http://localhost/prestashop/en/";

    public PrestashopApplication(WebDriver driver) {
        super(driver);
    }

    public HomePage goTo(){
        driver.get(URL);
        return new HomePage(driver);
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(driver);
    }

    public TopHeader getTopHeader() {
        return new TopHeader(driver);
    }

    //TODO: implement method to dynamically get page objects
}
