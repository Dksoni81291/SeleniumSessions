package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
		doSelectDropDownValue(country, "India");
		
//		Select select = new Select(driver.findElement(country));
		
//		List<WebElement> countryList = select.getOptions();
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
		
//		Select select = new Select(driver.findElement(country));
//		List<WebElement> countryList = select.getOptions();
//		System.out.println(countryList.size());
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
//		List<String> countryList = doGetDropDownOptions(country);
//		System.out.println(countryList.size());
//		System.out.println(countryList.contains("India"));
//		doSelectByVisibleText(country, "India");
//		
//		
//		Thread.sleep(2000);
//		
//		List<String> stateList = doGetDropDownOptions(state);
//		System.out.println(stateList.size());
//		System.out.println(stateList.contains("Goa"));
//		doSelectByVisibleText(state, "Goa");
		
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		List<String> OptionValList = new ArrayList<String>();
		for(WebElement e: OptionsList) {
			String text = e.getText();
			OptionValList.add(text);
		}
		
		return OptionValList;
	}
	
	public static void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
