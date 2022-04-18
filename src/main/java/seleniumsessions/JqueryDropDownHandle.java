package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		By choiceDropDown = By.id("justAnInputBox");
		By choiceListing = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//driver.findElement(By.id("justAnInputBox")).click();
		doClick(choiceDropDown);
		
		Thread.sleep(3000);
		
//		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class=\"comboTreeItemTitle\"]"));
//		
//		for(WebElement e: choiceList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("choice 1")) {
//				e.click();
//				break;
//			}
//		}
		
		//TC-01 : Single Selection
		//selectChoice(choiceListing, "choice 1");
		
		//TC-02 : Multi Selection
		//selectChoice(choiceListing, "choice 1","choice 2","choice 6 2 1");
		
		//TC-03 : All values from the drop-down
		selectChoice(choiceListing, "all");
		Thread.sleep(2000);
		DeselectChoice(choiceListing,"all");
	}
	
	

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = getElements(locator);
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement e: choiceList) {
			String text = e.getText();
			System.out.println(text);
				for(int i=0; i<value.length; i++) {
					if(text.equals(value[i])) {
					e.click();
					break;
					}
				}
			}
		}
		else {
			// All selection logic
			// As post 14 selection, it throws exception so we have to include try and catch block..
			try {
			for(WebElement e: choiceList) {
				e.click();
			}
			}catch(ElementNotInteractableException e) {
				System.out.println("All choices are over...");
			}
		}
	}
	
	public static void DeselectChoice(By locator, String... value) {
		List<WebElement> choiceList = getElements(locator);
		
		// Logic --> De-select --- Individual, and specific value pass
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement e: choiceList) {
			String text = e.getText();
			System.out.println(text);
				for(int i=0; i<value.length; i++) {
					if(text.equals(value[i])) {
					e.click();
					break;
					}
				}
			}
		}
		else {
			// All selection logic
			// As post 14 selection, it throws exception so we have to include try and catch block..
			try {
			for(WebElement e: choiceList) {	
				e.click();
			}
			}catch(ElementNotInteractableException e) {
				System.out.println("All choices are de-selected...");
			}
		}
	}

}
