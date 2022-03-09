package nit.application.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "nit.application.test", "nit.framework.webdriver" }, plugin = {
		"pretty", "html:Reports/AutomationTestReport.html" }, tags = "@Smoke or @Functional")

public class TestRunner {

}
