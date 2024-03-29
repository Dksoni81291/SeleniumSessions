package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartAppTest extends BaseTest{

	@Test(description = "verifying title test of demo cart application....")
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login");
	}

	@Test(enabled = true, description = "url test....")
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("account/login"));
	}

	@Test(description = "this is search test.....")
	public void searchTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		boolean flag = driver.findElement(By.name("search")).isDisplayed();
		Assert.assertTrue(flag);
	}

}
