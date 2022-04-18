package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {

	@Test(invocationCount = 3, priority = 2)
	public void loginPageTest() {
		System.out.println("In Login page test");
	}
	
	@Test(invocationCount = 2, priority = 1)
	public void homePageTest() {
		System.out.println("In Home page test");
	}
}
