package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLocators {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		//1. Id: Unique
		
		//2. name: Can be Duplicate
		
		//driver.findElement(By.name("email")).sendKeys("dksoni@gmail.com");
		//By email = By.name("email");
		//eleUtil.doSendKeys(email, "dksoni@gmail.com");
		
//		String email_id = "email";
//		By emailId = eleUtil.getBy("name", email_id);
//		eleUtil.doSendKeys(emailId, "dksoni@gmail.com");
		
		//3. className: can be same for different elements
//		
//		By ele = By.className("form-control");
//		driver.findElement(ele).sendKeys("test@gmail.com");

		//4. xpath: its not an attribute, its an address of an element inside html dom.
		
		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("dksoni@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("password");
//		// driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//		
//		By loginButton = By.xpath("//*[@id=\\\"content\\\"]/div/div[2]/div/form/input");
//		eleUtil.doClick(loginButton);
		
		//5. cssSelector: its not an attribute.
		
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("dksoni@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("password");
		
		//6. link text: Only for links.
		
		// html tag : <a>
//		By registerLink = By.linkText("Register");
//		eleUtil.doClick(registerLink);
		
		//7. PartialLinkText: Only for Links
//		By forgotPasswordLink = By.partialLinkText("Forgotten");
//		eleUtil.doClick(forgotPasswordLink);
		
		
		
		//8. tagName: html tag, not an attribute.
		
//		String text = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(text);
		
		By header = By.tagName("h2");
		By register = By.linkText("Register");
		
		String text = eleUtil.doElementGetText(header);
		System.out.println(text);
		String regtext = eleUtil.doElementGetText(register);
		System.out.println(regtext);

	}

}
