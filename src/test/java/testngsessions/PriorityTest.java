package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {
	
	@Test(priority = 1)
	public void a_test() {
		System.out.println("A Test");
	}
	
	@Test(priority = 2)
	public void b_test() {
		System.out.println("B Test");
	}
	
	@Test(priority = 3)
	public void c_test() {
		System.out.println("C Test");
	}
	
	@Test(priority = 5)
	public void d_test() {
		System.out.println("D Test");
	}
	
	@Test(priority = 4)
	public void e_test() {
		System.out.println("E Test");
	}
	
}
