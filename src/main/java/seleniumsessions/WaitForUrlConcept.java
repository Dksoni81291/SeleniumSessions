package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		waitForElementToBeVisible(emailId, 10).sendKeys("naveenanimation20@gmail.com");
		getElement(password).sendKeys("Selenium12345");
		getElement(loginBtn).click();
		
		System.out.println(waitForUrl(10, "route=account/account"));
		
		System.out.println(waitForTitleContains(5, "My"));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.urlContains("route=account/account"))) {
//			System.out.println("Login Successfull...");
//			Sytem.out.println(driver.getCurrentUrl());
//		}
	}

	public static String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitForTitleIs(int timeOut, String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static String waitForUrl(int timeOut, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
			return null;
	}
	
	
	public static String waitForUrlToBe(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
			return null;
	}
	
}
