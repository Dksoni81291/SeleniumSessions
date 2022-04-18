package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraverse {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		// "//*[@id=\"customers\"]/tbody/tr[2]/td[1]"
		// //*[@id="customers"]/tbody/tr[3]/td[1]
		// //*[@id="customers"]/tbody/tr[7]/td[1]
		
		By rows = By.xpath("//table[@id='customers']//tr");
		By columns = By.xpath("//table[@id='customers']//th");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		String before_xpath = "//*[@id='customers']/tbody/tr[";
		String after_xpath = "]/td[1]";
		
//		for(int i=2; i<=rowCount; i++) {
//			String xpath = before_xpath + i + after_xpath;
//			//System.out.println(xpath);
//			String text = driver.findElement(By.xpath(xpath)).getText();
//			System.out.println(text);
//		}
		
		System.out.println("Row Count is: "+ getRowCount(rows));
		System.out.println("Column Count is: "+ getColumnCount(columns));
		System.out.println("1st Column Data is -----");
		getColumnData(before_xpath, after_xpath, rows);
	}
	
	public static int getRowCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public static int getColumnCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public static void getColumnData(String before_xpath, String after_xpath, By Rows) {
		for(int row=2; row<=getRowCount(Rows); row++) {
			String xpath = before_xpath + row + after_xpath;
			//System.out.println(xpath);
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}

}
