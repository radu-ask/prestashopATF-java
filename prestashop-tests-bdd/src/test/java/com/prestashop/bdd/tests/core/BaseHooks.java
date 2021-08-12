package com.prestashop.bdd.tests.core;

import com.prestashop.bdd.tests.core.StepsHelper;
import com.prestashop.core.utils.LogUtil;
import com.prestashop.core.web.WebBrowserType;
import com.prestashop.core.web.WebDriverFactory;
import com.prestashop.domain.core.PrestashopApplication;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseHooks {
    private final Logger logger = LogUtil.getInstance();
    private final StepsHelper stepsHelper;

    public BaseHooks(StepsHelper stepsHelper) {
        this.stepsHelper = stepsHelper;
    }

    @Before
    public void setup(){
        WebDriver webDriver = WebDriverFactory.getDriver(WebBrowserType.CHROME);
        stepsHelper.setDriver(webDriver);
        stepsHelper.setApp(new PrestashopApplication(webDriver));
    }

    @After
    public void cleanUp(){
        if (stepsHelper.getDriver() != null){
            try {
                stepsHelper.getDriver().quit();
            }catch (Exception e){
                logger.error("Failed to quit the driver!");
                e.printStackTrace();
            }
        }
        // TODO: take screenshot on failure or work with Scenario
    }
}
