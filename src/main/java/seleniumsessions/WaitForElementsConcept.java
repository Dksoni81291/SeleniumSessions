package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");
		
		By footer = By.xpath("//ul[@class='footer-nav']//a");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		/**
		 * An expectation for checking that all elements present on the web page 
		 * that match the locator are visible. 
		 * Visibility means that the elements are not only displayed 
		 * but also have a height and width that is greater than 0.

		 */
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
//		
//		
//		for(WebElement e : footerList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		if(getElementsTextListWithWait(footer, 10).contains("Contact us")) {
			System.out.println("Contact us is present....");
		}

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static void printAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		List<WebElement> eleList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		for(WebElement e: eleList) {
			System.out.println(e.getText());
		}
	
	}
	
	public static List<String> getElementsTextListWithWait(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		List<WebElement> eleList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		List<String> eleTextList = new ArrayList<String>();
		
		for(WebElement e: eleList) {
			String text = e.getText();
			//System.out.println(e.getText());
			eleTextList.add(text);
		}
		return eleTextList;
	}
}
