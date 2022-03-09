package nit.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nit.framework.commons.WebCommons;
import nit.framework.utilities.ReadDataFromPropFile;
import nit.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons {
	
	@FindBy(xpath = "//img[contains(@src,'logo.png')]")
	private WebElement logo;

	@FindBy(xpath = "//div[@id='logInPanelHeading']")
	private WebElement logInPanelHeading;

	@FindBy(xpath = "//input[@id='txtUsername']")
	private WebElement usernameTextbox;

	@FindBy(xpath = "//input[@id='txtPassword']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	private WebElement loginButton;

	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPasswordLink;
	
	By welcomePage = By.xpath("//a[@id='welcome']");
	
	public void launchApplication() throws IOException {
		try {
			driver.get(ReadDataFromPropFile.readProperties("Config.properties").getProperty("url"));
		} catch (Exception e) {
			takeScreenshot("AppLaunch");			
			Assert.fail("Unable to launch the application");
		}
	}
	
	public void verifyApplicationTitle() throws IOException {
		try {
			Assert.assertEquals(getTitle(), ReadDataFromPropFile.readProperties("Config.properties").getProperty("title"));
		}catch(Exception e) {
			takeScreenshot("AppTitle");
			Assert.fail("Title Not Matching");
		}
	}
	
	public void verifyLoginPageHeader() throws IOException {
		try {
			Assert.assertEquals(getElementText(logInPanelHeading), ReadDataFromPropFile.readProperties("Config.properties").getProperty("pageHeader"));
		}catch(Exception e) {
			takeScreenshot("LoginHeader");
			Assert.fail("Login Page Header is not matching");
		}
	}
	
	public void updateUsernameAndPassword(String username, String password) throws IOException {
		try {
			EnterText(usernameTextbox, username);
			EnterText(passwordTextbox, password);
		}catch(Exception e) {
			takeScreenshot("UsernameNPass");
			Assert.fail("Unable to update Username and Password");
		}
	}
	
	public void loginIntoApplication() throws IOException {
		try {
			clickOnElement(loginButton);
		}catch(Exception e) {
			takeScreenshot("Login");
			Assert.fail("Error while login into the app");
		}
	}
	
	public void verifySuccessfullogin() throws IOException {
		try {
			waitForElement(welcomePage);
		}catch(Exception e) {
			takeScreenshot("WelcomePage");
			Assert.fail("Login is not successful");
		}
	}

	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}

}
