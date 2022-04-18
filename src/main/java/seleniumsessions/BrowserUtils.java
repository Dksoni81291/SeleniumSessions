package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {

	public WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of given browser.
	 * 
	 * @param browserName
	 * @return This returns the driver
	 */
	public WebDriver launchBrowser(String browserName) {

		System.out.println("Browser name is " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"D:\\AutomationDrivers\\chromedriver_win32_98\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"D:\\AutomationDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass correct browser option: " + browserName);
		}

		return driver;
	}

	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("Please pass the right URL... ");
			return;
		}

		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		} else {
			driver.close();
			try {
				throw new Exception("InvalidURLException - Please pass the right URL with http(s)..");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void launchUrl(URL url) {
		driver.navigate().to(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
