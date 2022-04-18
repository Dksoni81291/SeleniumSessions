package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHandleAssignment {

		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
			
			driver.get("http://automationpractice.com/index.php");
			
			driver.findElement(By.id("search_query_top")).sendKeys("dress");
			Thread.sleep(3000);
			
			List<WebElement> suggestions = driver
					.findElements(By.xpath("//div[@class='ac_results']/ul/li"));

			for (WebElement e : suggestions) {
				String text = e.getText();
				System.out.println(text);
				if (text.contains("Casual Dresses > Printed ")) {
					e.click();
					break;
				}
			}
	}

}
