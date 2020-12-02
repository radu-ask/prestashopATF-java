package com.prestashop.tests.login;

import com.prestashop.tests.TestBase;
import com.prestashop.domain.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyHomePageTitle() {
        String expectedTitle = "OLSO";
        HomePage homePage = new HomePage(getDriver());
        homePage.goTo();
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
