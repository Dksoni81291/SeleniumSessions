package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckbox {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		
		selectUserName("Joe.Root");
		Thread.sleep(1000);
		selectUserName("John.Smith");
		
		driver.close();
		
	}
	
	public static void selectUserName(String userName) {
		driver.findElement(By.xpath("//a[contains(text(),'"+userName+"')]/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
