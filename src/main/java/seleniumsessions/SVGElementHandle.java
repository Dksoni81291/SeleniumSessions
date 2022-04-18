package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementHandle {

	static WebDriver driver;
	//SVG = Scaler Vector Graph
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(5000);
				
		List<WebElement> stateList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']"));
		System.out.println(stateList.size());
		Actions act = new Actions(driver);
		
		for(WebElement e: stateList) {
			act.moveToElement(e).perform();
			String name = e.getAttribute("name");
			System.out.println(name);
			if(name.equals("Maryland")) {
				act.click(e).perform();
				break;
			}
		}
	}

}
