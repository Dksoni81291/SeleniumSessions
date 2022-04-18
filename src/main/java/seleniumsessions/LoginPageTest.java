package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {
		
		BrowserUtils br = new BrowserUtils();
		WebDriver driver = br.launchBrowser("chrome");
		
		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		String title = br.getPageTitle();
		System.out.println(title);
		System.out.println(br.getPageUrl());
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil el = new ElementUtil(driver);
		el.doSendKeys(email, "dksoni@gmail.com");
		el.doSendKeys(password, "password");
		
		br.closeBrowser();	
	}

}
