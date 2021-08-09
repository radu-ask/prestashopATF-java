package com.prestashop.tests.login;

import com.prestashop.core.utils.LogUtil;
import com.prestashop.domain.pages.HomePage;
import com.prestashop.tests.core.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    //TODO: Add fluent assertions to the framework. AssertJ?

    private static final Logger logger = LogUtil.getInstance();

    @Test(description = "Verify if the home page title is OLSO.")
    public void verifyHomePageTitle() {
        HomePage homePage = goToHomePage();
        String expectedTitle = "OLSO";
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }

    @Test(description = "Failing test.")
    public void failingTest(){
        Assert.assertEquals(1, 1, "Verify if values are equal.");
    }
}
