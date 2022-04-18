package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

		// 1. TopCasting Option - valid
		// WebDriver driver = new ChromeDriver();
		
		// 2. valid
		//WebDriver driver = new FirefoxDriver();
		
		// 3. valid one remote execution
		//WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities)
				//url of remote server
				// capabilities : version
		
		// 4. valid but not useful
		// SearchContext driver = new ChromeDriver();
		// with this option- only 2 methods available - findElement and findElements
		
		// 5. valid but not useful
		// SearchContext driver = new RemoteWebDriver(remoetAddress, capabilities);
		// with this option- only 2 methods available - findElement and findElements
		
		// 6. valid, but Java recommends to use top casting with parent interface instead of using class.
		
		RemoteWebDriver driver = new ChromeDriver();
		
		
	}

}
