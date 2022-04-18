package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
			
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			// By country = By.id("Form_submitForm_Country");
			
//			WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//			
//			Select select = new Select(country);
//			driver.manage().window().maximize();
//			
//			// Index count starts from zero
//			//select.selectByIndex(5);
			
			// text of the option tag
			//select.selectByVisibleText("India");
			
			// value of "value" attribute of option tag
			//select.selectByValue("Algeria");
//			Thread.sleep(2000);
//			
//			WebElement state = driver.findElement(By.id("Form_submitForm_State"));
//			Select select1 = new Select(state);
//			select1.selectByVisibleText("Gujarat");
			
			By country = By.id("Form_submitForm_Country");
			By state = By.id("Form_submitForm_State");
			
			//WebElement countrySelection = getElement(country);
			//doSelectByVisibleText(country, "India");
			//doSelectByVisibleIndex(country, 5);
			//doSelectByVisibleText(country, "India");
			
			
			doSelectByVisibleText(country, "India");
			Thread.sleep(2000);
			doSelectByVisibleText(state, "Gujarat");
			
			Select select = new Select(driver.findElement(country));
			System.out.println(select.isMultiple());
			select.getAllSelectedOptions();
			
	}
		
			public static WebElement getElement(By locator) {
				return driver.findElement(locator);
			}

			public static void doSelectByVisibleText(By locator, String text) {
				Select select = new Select(getElement(locator));
				select.selectByVisibleText(text);
			}
			
			public static void doSelectByVisibleIndex(By locator, int index) {
				Select select = new Select(getElement(locator));
				select.selectByIndex(index);
			}
			
			public static void doSelectByValue(By locator, String text) {
				Select select = new Select(getElement(locator));
				select.selectByValue(text);
			}
}
