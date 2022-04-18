package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebStaticTraverseAssignment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		By rows = By.xpath("//table[@id='customers']//tr");
		By columns = By.xpath("//table[@id='customers']//th");
		int rowsCount = getRowCount(rows);
		int columnCount = getColumnCount(columns);

		for(int row=2; row<rowsCount; row++) {
			for(int column=1; column<=columnCount; column++) {
				String before_xpath = "//*[@id='customers']/tbody/tr[";
				String after_xpath = "]/td[";
				String ending = "]";
				String xpath = before_xpath + row + after_xpath + column + ending;
				//String xpath = "//*[@id='customers']/tbody/tr[row]/td[column]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text);
				System.out.print(" || ");
			}
			System.out.println();
			System.out.println("==================================================");
		}
		
	}
	
	public static int getRowCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public static int getColumnCount(By locator) {
		return driver.findElements(locator).size();
	}
	

}
