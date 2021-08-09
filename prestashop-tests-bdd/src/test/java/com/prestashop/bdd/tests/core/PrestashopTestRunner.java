package com.prestashop.bdd.tests.core;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/ui",
        glue = {"com/prestashop/bdd/tests/steps", "com/prestashop/bdd/tests/core"},
        plugin = {"pretty", "html:output/reports/cucumber.html"})
public class PrestashopTestRunner {
    // TODO: integrate bdd module with web driver
 }
