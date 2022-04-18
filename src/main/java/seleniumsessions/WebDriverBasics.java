package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\AutomationDrivers\\chromedriver_win32_98\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome browser

		driver.get("https://google.com"); // enter Url
		String title = driver.getTitle(); // get the page Title
		System.out.println(title);

		// checkpoint : actual vs expected result , assertions
		// Automation Testing
		
		if (title.equals("Google")) {
			System.out.println("Correct");
		} else {
			System.out.println("Incorrect");
		}
		System.out.println(driver.getCurrentUrl().contains("google"));
		System.out.println(driver.getPageSource().contains("Copyright The Closure Library Authors"));
		driver.quit(); // Close the browser
		
		
	}

}
