package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By emailId = By.id("input-email1");
		driver.findElement(emailId).sendKeys("test@gmail.com");
		// org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element:
		
		
//		boolean flag = driver.findElement(emailId).isDisplayed();
//		System.out.println(flag);
//		
		
		// boolean flag = eleUtil.doIsDisplayed(emailId);
//		if(eleUtil.doIsDisplayed(emailId)) {
//			eleUtil.doSendKeys(emailId, "test@gmail.com");
//		}
//		
//		driver.findElement(emailId).isEnabled();
//		
	}

}
