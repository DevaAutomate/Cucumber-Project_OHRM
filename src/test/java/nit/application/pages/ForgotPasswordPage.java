package nit.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import nit.framework.commons.WebCommons;
import nit.framework.webdriver.WebDriverClass;

public class ForgotPasswordPage extends WebCommons{

	// This class will be used to maintain all methods and elements related to
	// Forgot Password page
	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//input[@id='securityAuthentication_userName']")
	private WebElement usernameTxtb;

	@FindBy(xpath = "//input[@id='btnSearchValues']")
	private WebElement resetPasswordBtn;

	@FindBy(xpath = "//input[@id='btnCancel']")
	private WebElement cancelBtn;

	public void verifyForgotPasswordPageElements() throws IOException {
		try {
			clickOnElement(forgotPasswordLink);
			usernameTxtb.isDisplayed();
			resetPasswordBtn.isDisplayed();
			cancelBtn.isDisplayed();
		} catch (Exception e) {
			takeScreenshot("ForgotPasswordPage");
			Assert.fail("Forgot Password Page Elements not Available");
		}
	}

	public static ForgotPasswordPage getForgotPasswordPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotPasswordPage.class);
	}
}
