package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// Implicit Wait
		// Explicit Wait
		// a. WebDriverWait - for a specific element, custom wait, Non webelements- Alerts, Url, Title.
		// b. FluentWait

		// WebDriverWait(C) extends FluentWait(C) implements Wait(Interface) - until()

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //sel 4.x
		//WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		
		WebElement email = waitForElementToBeVisible(emailId, 10);
		email.sendKeys("test@gmail.com");
		
		WebElement pwd = waitForElementPresent(password, 2);
		pwd.sendKeys("test@123");
		
		//driver.findElement(password).sendKeys("test@123");
		//driver.findElement(loginBtn).click();
		getElement(loginBtn).click();
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.

	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
	

}
