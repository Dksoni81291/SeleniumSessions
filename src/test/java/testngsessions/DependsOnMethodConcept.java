package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	//avoid dependency in tests
	//test cases -- should independent to each other
	
	@Test
	public void loginTest() {
		System.out.println("In Login Page Test");
		int i = 9/2;
	}

	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("IN Home Page Test");
		int j = 9/0;
	}
	
	@Test(dependsOnMethods = {"loginTest", "homePageTest"})
	public void SearchTest() {
		System.out.println("In Search Test");
	}
}
