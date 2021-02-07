package com.prestashop.tests.login;

import com.prestashop.domain.pages.ClothesPage;
import com.prestashop.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyHomePageTitle() {
        String expectedTitle = "OLSO";
        ClothesPage clothesPage = new ClothesPage(getDriver());
        clothesPage.getCheckboxMen().toggle();
        Assert.assertTrue(clothesPage.getCheckboxMen().isChecked());
    }
}
