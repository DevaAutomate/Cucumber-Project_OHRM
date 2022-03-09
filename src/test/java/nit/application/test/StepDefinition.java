package nit.application.test;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nit.application.pages.ForgotPasswordPage;
import nit.application.pages.LoginPage;

public class StepDefinition {

	@Given("Launch the application")
	public void launch_the_application() throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchApplication();
	}

	@Then("Verify application title")
	public void verify_application_title() throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyApplicationTitle();
	}

	@Then("Verify loginpage header")
	public void verify_loginpage_header() throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginPageHeader();
	}

	@When("^I enter (.*) and (.*)$")
	public void enterUsernameAndPassword(String username ,String password) throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.updateUsernameAndPassword(username, password);
	}

	@When("Click on login button")
	public void click_on_login_button() throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.loginIntoApplication();
	}

	@Then("Application login should be successful")
	public void application_login_should_be_successful() throws IOException {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifySuccessfullogin();
	}

	@Then("Verify fogotpassword functionality")
	public void verify_fogotpassword_functionality() throws IOException {
		ForgotPasswordPage forgotPass = ForgotPasswordPage.getForgotPasswordPage();
		forgotPass.verifyForgotPasswordPageElements();

	}
}
