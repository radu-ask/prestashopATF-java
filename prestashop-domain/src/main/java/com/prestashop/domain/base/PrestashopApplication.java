package com.prestashop.domain.base;

import com.prestashop.core.utils.Constants;
import com.prestashop.core.utils.logger.LogUtil;
import com.prestashop.core.web.WebApplication;
import com.prestashop.domain.pages.HomePage;
import com.prestashop.domain.pages.components.NavigationMenu;
import com.prestashop.domain.pages.components.TopHeader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PrestashopApplication extends WebApplication {

    private final Logger logger = LogUtil.getInstance();

    public PrestashopApplication(WebDriver driver) {
        super(driver, Constants.APPLICATION_URL);
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu(getDriver());
    }

    public TopHeader getTopHeader() {
        return new TopHeader(getDriver());
    }

    // TODO: integrate the framework with cucumber BDD
    // TODO: integrate the framework with Jenkins - create app environment functionality
    // TODO: implement method to dynamically get page objects?
}
