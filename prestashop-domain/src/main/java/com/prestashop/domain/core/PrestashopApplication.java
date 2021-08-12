package com.prestashop.domain.core;

import com.prestashop.core.utils.Constants;
import com.prestashop.core.utils.LogUtil;
import com.prestashop.core.web.WebApplication;
import com.prestashop.domain.pages.HomePage;
import com.prestashop.domain.pages.components.NavigationMenu;
import com.prestashop.domain.pages.components.TopHeader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PrestashopApplication extends WebApplication {
    private final Logger logger = LogUtil.getInstance();

    public PrestashopApplication(WebDriver driver) {
        super(driver, Constants.APPLICATION_URL);
    }

    public HomePage goToHomePage(){
        HomePage homePage = new HomePage(getDriver());
        try { // TODO: implement fluent wait method to verify if element is displayed
            if(homePage.getPopularProductsHeader().isDisplayed()){
                return homePage;
            }
        }catch (NoSuchElementException exception){
            getNavigationMenu().getLogo().click();
        }
        return homePage;
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(getDriver());
    }

    public TopHeader getTopHeader() {
        return new TopHeader(getDriver());
    }

    // TODO: integrate the framework with Jenkins - create app environment functionality
    // TODO: configure the test env from the Jenkins job
    // TODO: implement a method to wait for page to load
}
