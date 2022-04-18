package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		
//		WebElement content = driver.findElement(By.xpath("//a[@class='menulink']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(content).build().perform();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("COURSES")).click();
		
		By parentMenu = By.xpath("//a[@class='menulink']");
		By childMenu = By.linkText("COURSES");
		
		selectSubMenu(parentMenu, childMenu);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).build().perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu1, By childMenu2, By childMenu3) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu2)).build().perform();
		Thread.sleep(2000);
		getElement(childMenu3).click();
	}
}
