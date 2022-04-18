package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverBigBasket {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		
		By Category = By.xpath("//a[@qa='categoryDD']");
		By beverages = By.linkText("Beverages");
		By tea = By.linkText("Tea");
		By GreenTea = By.linkText("Green Tea");
		
		driver.findElement(Category).click();
		
		ElementUtil ele = new ElementUtil(driver);
		ele.selectSubMenu(Category, beverages, tea, GreenTea);
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
