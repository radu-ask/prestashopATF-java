package com.prestashop.test.login;

import com.prestashop.test.core.TestBase;
import com.prestashop.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyHomePageTitle(){
        String expectedTitle = "OLSO";
        HomePage homePage = new HomePage(driver);
        homePage.goTo();
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
