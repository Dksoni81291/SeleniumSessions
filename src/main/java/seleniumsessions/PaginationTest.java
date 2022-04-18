package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PaginationTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		int pageCount = 1;
		while(true) {
			
			if(driver.findElements(By.xpath("//td[text()='Bengaluru']")).size() >0) {
				selectCity("Bengaluru");
				System.out.println("Page count: "+pageCount);
				break;
			}
			else {
				// pagination logic
				WebElement next = driver.findElement(By.linkText("Next"));
					if(next.getAttribute("class").contains("disabled")) {
						System.out.println("Pagination is over..Record is not found...");
						break;
					}
				next.click();
				Thread.sleep(2000);
				pageCount ++;
			}
			
		}
		
	}
	
	public static void selectCity(String cityName) {
		driver.findElement(By.xpath("//td[text()='" +cityName+ "']//preceding-sibling::td//child::input[@type='checkbox']")).click();
	}
	
	
	public static void selectCity1(String cityName) {
		
		WebElement ele = driver.findElement(By.xpath("//td[text()='"+cityName+"'"));
		driver.findElement(with(By.xpath("input[@type='checkbox']")).toLeftOf(ele)).click();
	}
	
	
	/*
	 * # Start Writing Here
		page_count = 1
		while loop
    		if element found on the first page
        		select the checkbox against that element
        		print the page_count
        		Exit Loop
    		else
        		# Pagination Logic
        		Locate the WebElement for the Next button
            	# Check and add condition for Next button disable.
            		if next button is disabled
                		Element is not found in the Table
                		Exit loop
        		Click on the next button
        		page_count += 1

	 */

}
