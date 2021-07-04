package com.prestashop.bdd.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("User is on HomePage")
    public void user_is_on_home_page() {
        System.out.println("step 1");
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
