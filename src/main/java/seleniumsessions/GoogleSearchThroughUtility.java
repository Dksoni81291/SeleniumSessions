package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchThroughUtility {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		By searchbox = By.name("q");
		doSendKeys(searchbox, "Naveen Automation Labs");
		Thread.sleep(3000);
		By suggestions = By.xpath("//ul[@role=\"listbox\"]/li//div[@class='wM6W7d']//span");
		getSuggestions(suggestions, "interview questions");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void getSuggestions(By locator, String searchText) {
			
		List<WebElement> suggestions = getElements(locator);
		for(WebElement e: suggestions) {
			String text = e.getText();
			//System.out.println(text);
			if(text.contains(searchText)) {
				e.click();
				break;
			}
		}
	}

}
