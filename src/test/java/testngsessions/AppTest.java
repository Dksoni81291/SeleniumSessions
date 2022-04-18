package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	// Global Pre-Conditions
	// Pre-conditions
	// test steps + Actual vs Expected Result
	// post steps
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS--Connect with DB");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT -- Create User");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC --- Launch Browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM --- Login to App");
	}
	
	@Test
	public void titleTest() {
		System.out.println("Test of Title");
	}
	
	@Test
	public void headerTest() {
		System.out.println("Test of Header");
	}
	
	@Test
	public void isUserLoggedInTest() {
		System.out.println("User is Logged in");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("User is logged out");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC-- Close Browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- Delete User");
	}
	
	@AfterSuite
	public void closeDBConnection() {
		System.out.println("AS -- Close DB Connection");
	}
	
}
