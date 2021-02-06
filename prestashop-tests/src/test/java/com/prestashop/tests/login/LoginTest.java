package com.prestashop.tests.login;

import com.prestashop.tests.base.TestBase;
import com.prestashop.domain.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyHomePageTitle() {
        String expectedTitle = "OLSO";
        HomePage homePage = getPrestashopApplication().goTo();
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        homePage.deleteTextFromElement(getPrestashopApplication().getNavigationMenu().getTextboxSearch());
    }
}
