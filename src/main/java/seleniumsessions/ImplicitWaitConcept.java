package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// script --> App
		// Thread.sleep(5000) --> Static Wait
		
		// Dynamic Wait 
			// Implicitly wait
				// global wait
				// Applicable for all the elements
				// FE: Implicitly wait will be applied to all element by default.
		
		// It works only for WebElements
		// Doesn't work for Non-WebElements: Alert, Url and title.
		// avoid the usage of Implicit wait in framework design.
		// timeout - 10sec --> After 2 sec element found, rest 8 seconds will be ignored.
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		// e3, e4, e5, ..... nth element -- This Implicitly wait is applied - Hence- Known as Global wait.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		/*
		 * Specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 

		When searching for a single element, the driver should poll the page 
		until the element has been found, or this timeout expires before throwing a NoSuchElementException. 
		When searching for multiple elements, the driver should poll the page until 
		at least one element has been found or this timeout has expired. 

		Increasing the implicit wait timeout should be used judiciously 
		as it will have an adverse effect on test run time, especially when used with slower location strategies like XPath. 

		 */
	}

}
