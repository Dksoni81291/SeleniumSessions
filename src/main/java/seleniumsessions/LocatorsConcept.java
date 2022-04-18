package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		 //1st Approach: Basic
//		driver.findElement(By.id("input-email")).sendKeys("dksoni@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("password");
		
		//2nd Approach: Through WebElement and action later on it.
		
//		  WebElement EmailID = driver.findElement(By.id("input-email")); 
//		  WebElement password = driver.findElement(By.id("input-password"));
//		  
//		  EmailID.sendKeys("dksoni@gmail.com"); 
//		  password.sendKeys("password");
		 
		// 3rd Approach: By locator: Object Repository
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		//driver.findElement(email).sendKeys("dksoni@gmail.com");
//		//driver.findElement(password).sendKeys("password");
//		
//		WebElement Email = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		
//		Email.sendKeys("dksoni@gmail.com");
//		pwd.sendKeys("password");
		
		// 4th Approach: By generic function
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(email).sendKeys("dksoni@gmail.com");
//		getElement(password).sendKeys("password");

		//5th Approach: By generic function(getElement + doSendKeys)
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "dksoni@gmail.com");
//		doSendKeys(password, "password");
		// driver.close();
		
		//6th Approach: By generic function(getElement + doSendKeys) but through ElementUtils class.
		
//		ElementUtil el = new ElementUtil(driver);
//			
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//
//		el.doSendKeys(email, "dksoni@gmail.com");
//		el.doSendKeys(password, "password");
		
		//7th Approach - through BrowserUtils and ElementUtil
		
		//8th Approach - String Locator --> By Locator
		
		String email_id = "input-email";
		String password_id = "input-password";
		
		ElementUtil el = new ElementUtil(driver);
		By email = el.getBy("ID",email_id);
		By password = el.getBy("ID", password_id);
		
		el.doSendKeys(email, "dksoni@gmail.com");
		el.doSendKeys(password, "password");
	}
	public static By getBy(String LocatorType, String LocatorValue) {
		By locator = null;
		switch (LocatorType.toLowerCase()) {
		case "id":
			locator = By.id(LocatorValue);
			break;
		default:
			break;
		}
		return locator;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	

}
