package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		String hrefVal = driver.findElement(By.linkText("Gift Cards")).getAttribute("href");
		System.out.println(hrefVal);
		
		By links = By.tagName("a");
		List<WebElement> list = getElements(links);
		
		//List<String> eleAttrList = getElementAttributeList(links, "href");
		
		By images = By.tagName("img");
		System.err.println("Total no of Images: "+ getElements(images).size());
		
		List<String> srcListImages = getElementAttributeList(images, "src");
		List<String> altListImages = getElementAttributeList(images, "alt");
		
		
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getElementAttributeList(By locator, String attrName) {
		
		List<WebElement> eleList= getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attrName);
			System.out.println(attrValue);
			eleAttrList.add(attrValue);
		}
		
		return eleAttrList;
	}
}
