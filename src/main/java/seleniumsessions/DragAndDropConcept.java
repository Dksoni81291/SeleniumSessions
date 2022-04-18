package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		//By sourceElement = By.id("draggable");
		//By targetElement = By.id("droppable");
		
		Actions act = new Actions(driver);
		//act.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
		
		act.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}

}
