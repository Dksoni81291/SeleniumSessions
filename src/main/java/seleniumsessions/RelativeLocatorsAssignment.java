package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
//		WebElement ele = driver.findElement(By.xpath("//label[normalize-space()='Yes']"));
//		System.out.println(driver.findElement(with(By.xpath("//label[@text='Subscribe']")).toLeftOf(ele)).getText());

		WebElement privacyPolicy = driver.findElement(By.cssSelector("a.agree"));
		driver.findElement(with(By.xpath("//input[@type='checkbox' and @name='agree']")).toRightOf(privacyPolicy)).click();
		
		WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']"));
		
		driver.findElement(with(By.tagName("input")).toRightOf(chkbox));
		//System.out.println(continBtn);
		
		
	}

}
