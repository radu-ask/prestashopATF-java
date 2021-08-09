package com.prestashop.bdd.tests.steps;

import com.prestashop.bdd.tests.core.StepsHelper;
import com.prestashop.domain.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private final StepsHelper stepsHelper;

    public LoginSteps(StepsHelper stepsHelper){
        this.stepsHelper = stepsHelper;
    }

    @Given("User is on HomePage")
    public void user_is_on_home_page() {
        System.out.println("step 2");
        HomePage homePage = stepsHelper.goToHomePage();
        String expectedTitle = "OLSO";
        Assert.assertEquals(stepsHelper.getDriver().getTitle(), expectedTitle);

    }

    @When("User clicks on Sign In button")
    public void user_clicks_on_sing_in_button() {
        System.out.println("step 2");
    }

    @Then("LoginPage is displayed")
    public void login_page_is_displayed() {
        System.out.println("step 3");
    }
}
