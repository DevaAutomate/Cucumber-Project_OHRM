package nit.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import nit.framework.commons.WebCommons;
import nit.framework.webdriver.WebDriverClass;

public class HomePage extends WebCommons{

	//This class will be used to maintain all methods and elements related to Home page
	
	@FindBy(xpath ="//a[@id='welcome']")
	private WebElement welcomeLabel;
	
	By bywelcomeLabel = By.xpath("//a[@id='welcome']");
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	By bylogoutButton = By.xpath("//a[text()='Logout']");

	By byLoginPanelHeading = By.xpath("//div[@id='logInPanelHeading']");
	
	public void verifyApplicationLogout() throws IOException {
		try {
			clickOnElement(welcomeLabel);
			waitForElement(bylogoutButton);
			clickOnElement(logoutButton);
			waitForElement(byLoginPanelHeading);
		} catch (Exception e) {
			takeScreenshot("ApplicationLogout");
			Assert.fail("Application Logout is Not Successful");
		}
	}
	
	public static HomePage getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), HomePage.class);
	}
}
