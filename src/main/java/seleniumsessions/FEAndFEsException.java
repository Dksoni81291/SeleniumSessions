package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FEAndFEsException {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		// driver.findElement(By.linkText("Customers111")).click();
		// NoSuchElementException

		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		System.out.println(footerList.size());

		if (footerList.size() > 0) {
			System.out.println("Footers are present on the page....");
			for (WebElement e : footerList) {
				String text = e.getText();
				System.out.println(text);
			}
		}

//		if (driver.findElements(By.linkText("Customers")).size() > 0) {
//			System.out.println("Customer link is present on the page...");
//		}

		boolean flag = isElementPresent(By.linkText("Customers"));
		System.out.println(flag);
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static boolean isElementPresent(By Locator) {

		if (getElements(Locator).size() > 0) {
			return true;
		}
		return false;
	}

}
