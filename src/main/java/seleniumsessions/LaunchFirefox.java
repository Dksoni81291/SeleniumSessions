package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\AutomationDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// WebDriver driver = new SafariDriver();
		

		driver.get("https://google.com"); // enter Url
		String title = driver.getTitle(); // get the page Title
		System.out.println(title);
		
		driver.quit();
	}

}
