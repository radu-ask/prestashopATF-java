package com.prestashop.tests.login;

import com.prestashop.core.utils.logger.LogUtil;
import com.prestashop.tests.core.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static final Logger logger = LogUtil.getInstance();

    @Test(description = "Verify if the home page title is OLSO.")
    public void verifyHomePageTitle() {
        getPrestashopApplication().goTo();
        logger.info("Accessed the application.");
        String expectedTitle = "OLSO";
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }
}
