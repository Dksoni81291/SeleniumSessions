package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\AutomationDrivers\\chromedriver_win32_98\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome browser

		driver.get("https://google.com"); // enter Url
		String title = driver.getTitle(); // get the page Title
		System.out.println(title);
		
		driver.quit();
	}

}
