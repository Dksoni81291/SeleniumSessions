package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//WebElement  --- Right ---Left --- Above --- Below ---- Nearby
		
		driver.get("https://www.aqi.in/dashboard/canada");
		driver.manage().window().maximize();
		
		
		WebElement city = driver.findElement(By.linkText("Windsor, Canada"));
		
		String index = driver.findElement(with(By.tagName("p")).toRightOf(city)).getText();
		System.out.println(index);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(city)).getText();
		System.out.println(rank);
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(city)).getText();
		System.out.println(belowCity);
	
		String aboveCity = driver.findElement(with(By.tagName("p")).above(city)).getText();
		System.out.println(aboveCity);
		
		String near = driver.findElement(with(By.tagName("p")).near(city)).getText();
		System.out.println(near);
		
		List<WebElement> aboveList = driver.findElements(with(By.tagName("a")).above(city));
		for(WebElement e: aboveList) {
			System.out.println(e.getText());
		}
		
	}

}
