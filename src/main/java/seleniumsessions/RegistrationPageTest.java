package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://demo.opencart.com/index.php?route=account/register";

		BrowserUtils brUtil = new BrowserUtils();
		WebDriver driver = brUtil.launchBrowser("Chrome");
		
		brUtil.launchUrl(url);
		String title = brUtil.getPageTitle();
		System.out.println("Page title is: "+title);
		
		driver.manage().window().maximize();
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By policyCheckbox = By.xpath("//input[@name='agree']");
		By continueButton= By.xpath("//input[@value='Continue']");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Dhrumil");
		eleUtil.doSendKeys(lastName, "Soni");
		eleUtil.doSendKeys(email, "dksoni@gmail.com");
		eleUtil.doSendKeys(telephone, "7718844550");
		eleUtil.doSendKeys(password, "password");
		eleUtil.doSendKeys(confirmPassword, "password");
		eleUtil.doClick(policyCheckbox);
		eleUtil.doClick(continueButton);
		
		Thread.sleep(2000);
		
		brUtil.closeBrowser();
	}

}
