package nit.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import nit.framework.utilities.ReadDataFromPropFile;

public class WebDriverClass {

	// This class will have all the common methods to handle any kind of browser

	protected WebDriver driver;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	// Method to launch new browser window
	@Before
	public void launchBrowser() {
		String browser = ReadDataFromPropFile.readProperties("Config.properties").getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		SetWebDriver(driver);
		driver.manage().window().maximize();
	}

	// Method to close browser windows
	@After
	public void closeBrowser() {
		driver.quit();

	}

	public synchronized static void SetWebDriver(WebDriver driver) {
		thread.set(driver);
	}

	// Method to share driver details with all other classes
	public synchronized static WebDriver getDriver() {
		return thread.get();
	}

}
