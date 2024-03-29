package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		By rightClickBtn = By.xpath("//span[text()='right click me']");
		By rightClickOptions = By.xpath("//ul[@class='context-menu-list context-menu-root']//span");

//		Actions act = new Actions(driver);
//		act.contextClick(driver.findElement(rightClickBtn)).perform();
//		List<WebElement> rightClickOptions2 = driver.findElements(rightClickOptions);
//		System.out.println(rightClickOptions2.size());
		
		if(getRightClickOptionsCount(rightClickBtn, rightClickOptions) == 6) {
			System.out.println("Pass");
		}
		
		selectRightClickMenu(rightClickBtn, rightClickOptions, "Copy");
		
	}

	public static void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(locator)).perform();
	}
	
	public static int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
		return getRightClickOptionsList(rightClick, rightClickOptions).size();
	}

	public static List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {

		WebElement rightClickEle = driver.findElement(rightClick);
		List<WebElement> rightClickItemList = driver.findElements(rightClickOptions);
		List<String> rightClickItems = new ArrayList<String>();

		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();

		for (WebElement e : rightClickItemList) {
			String text = e.getText();
			System.out.println(text);
			rightClickItems.add(text);
		}
		return rightClickItems;
	}

	public static void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
		WebElement rightClickEle = driver.findElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		List<WebElement> itemsList = driver.findElements(rightClickOptions);
		System.out.println(itemsList.size());
		for (WebElement e : itemsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
}
