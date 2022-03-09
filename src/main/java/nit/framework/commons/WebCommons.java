package nit.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nit.framework.webdriver.WebDriverClass;

public class WebCommons {

	// This class will have all the common methods to handle any kind of web
	// application

	public WebDriver driver = WebDriverClass.getDriver();

	// Method to get page title
	public String getTitle() {
		return driver.getTitle();
	}

	// Method to refresh/reload the page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Method to implicitly wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Method to wait for element
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// Method to perform click action on element
	public void clickOnElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

	// Method to enter text in textbox element
	public void EnterText(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.clear();
		element.sendKeys(value);
	}

	// Method to select option from dropdown
	public void selectOption(WebElement element, String option, String by) {
		Select s = new Select(element);
		if (by.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(option));
		} else if (by.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		} else if (by.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(option);
		}
	}

	// Method to select checkbox
	public void selectChecbox(WebElement element) {
		if (!element.isSelected())
			element.click();
	}

	// Method to perform double click
	public void doubleClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	// Method to get text from element
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// Method to get button label
	public String getButtonLabel(WebElement element) {
		return element.getAttribute("value");
	}

	// Method to get hyperlink
	public String getHyperlink(WebElement element) {
		return element.getAttribute("href");
	}

	// Method to collect screenshot
	public String takeScreenshot(String screenshotName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		try {
			FileUtils.copyFile(screenshotFile, new File(screenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotpath;
	}

	// Method to generate random id
	public String uniqueId() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmm");
		String uniqueid = sdf.format(Calendar.getInstance().getTime());
		return uniqueid;
	}

}
