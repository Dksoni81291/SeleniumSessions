package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementAssignment {

	static WebDriver driver;
	//SVG = Scaler Vector Graph
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/index.htm");
		
		Thread.sleep(5000);
		
		WebElement Home = driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon='home']//*[name()='path']"));
		Actions act = new Actions(driver);
		
		act.moveToElement(Home).click().build().perform();
		
	}

}
