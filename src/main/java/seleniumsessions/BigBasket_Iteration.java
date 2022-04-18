package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasket_Iteration {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.bigbasket.com/");
			driver.manage().window().maximize();
			
			WebElement mainCategory = driver.findElement(By.className("meganav-shop"));
			
			Actions act = new Actions(driver);
			act.moveToElement(mainCategory).build().perform();
			Thread.sleep(2000);
			
			List<WebElement> leve1List = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//a"));
			
			for(WebElement e1: leve1List) {
				act.moveToElement(e1).perform();
				System.out.println(e1.getText());
				System.out.println("============================================================");
				
				List<WebElement> level2List = driver.findElements(By.xpath("(//ul[contains(@class,'nav-stacked')])[4]//a"));
				
				for(WebElement e2: level2List) {
					act.moveToElement(e2).perform();
					System.out.println(e2.getText());
					
					List<WebElement> level3List = driver.findElements(By.xpath("(//div[@class='box']//ul[@class='list-unstyled'])[3]//a"));
					
					for(WebElement e3: level3List) {
						act.moveToElement(e3).perform();
						System.out.println(e3.getText());
					}
				}
				
			}
			
			driver.close();
			
	}

}
