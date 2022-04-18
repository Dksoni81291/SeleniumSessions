package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("(//div[@class='sc-bkkeKt gAqCbJ fswFld '])[3]")).click();

		selectFutureDate("March 2023", "23");

	}

	public static void selectFutureDate(String expMonthYear, String dateNum) throws InterruptedException {

		if (Integer.parseInt(dateNum) > 31) {
			System.out.println("Wrong date passed ...Please pass the correct day/date...");
			return;
		}
		if (expMonthYear.contains("February") && Integer.parseInt(dateNum) > 29) {
			System.out.println("Wrong date passed ... Please pass the correct day/date ....");
			return;
		}

		if ((expMonthYear.contains("April") || expMonthYear.contains("June") || expMonthYear.contains("September")
				|| expMonthYear.contains("November")) && Integer.parseInt(dateNum) > 30) {
			System.out.println("Please pass correct date..");
			return;
		}

		
		List<String> currentMonthYearList = new ArrayList<String>();
		List<WebElement> CurentMonthYear = driver.findElements(By.cssSelector(".DayPicker-Caption"));

		for (WebElement e : CurentMonthYear) {
			String text = e.getText();
			currentMonthYearList.add(text);
		}

		while (!currentMonthYearList.contains(expMonthYear)) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			currentMonthYearList = new ArrayList<String>();
			CurentMonthYear = driver.findElements(By.cssSelector(".DayPicker-Caption"));
			for (WebElement e : CurentMonthYear) {
				String txt = e.getText();
				currentMonthYearList.add(txt);
			}
		}

		Thread.sleep(3000);
		if(currentMonthYearList.get(0).contains(expMonthYear)) {
			selectDate1(dateNum);
		}
		else
		{
			selectDate2(dateNum);
		}
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		}
	
	
	// Selecting the date from left side calendar table
	public static void selectDate1(String date) {
		driver.findElement(By.xpath("(//div[@class='DayPicker-Day']/p[text()='" + date + "'])[1]")).click();
	}

	// Selecting the date from right side calendar table
	public static void selectDate2(String date) {

		driver.findElement(By.xpath("(//div[@class='DayPicker-Day']/p[text()='" + date + "'])[2]")).click();
	}

}
