package com.prestashop.tests.login;

import com.prestashop.core.utils.logger.LogUtil;
import com.prestashop.domain.pages.HomePage;
import com.prestashop.tests.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static final Logger logger = LogUtil.getInstance();

    @Test(description = "Verify if the home page title is OLSO.")
    public void verifyHomePageTitle() {
        HomePage homePage = getApp();
        String expectedTitle = "OLSO";
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }

    @Test(description = "Failing test.")
    public void failingTest(){
        Assert.assertEquals(1, 0);
    }
}
