package com.prestashop.bdd.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/prestashop/bdd/tests/features/ui",
        glue = "com/prestashop/bdd/tests/steps",
        plugin = {"pretty",
                "html:output/reports/cucumber.html"})
public class PrestashopRunner{
    // TODO: add cucumber.properties / what other properties can be added?
    // TODO: try to build both test modules with maven
    // TODO: integrate bdd module with web driver
    // TODO: see if it is needed to integrate test ng with cucumber
 }
