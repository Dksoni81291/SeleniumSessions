package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		
		// List<WebElement> footerList = driver.findElements(By.cssSelector("ul.footer-nav li a"));
		
		for(WebElement e: footerList) {
			String text = e.getText();
			System.out.println(text);
		}
		
		
		List<WebElement> BottomList = driver.findElements(By.xpath("//div[@class='footer-nav copyrights-nav hide-in-mobile']//a"));
		for(WebElement e: BottomList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
