package practicePackage;

import org.testng.annotations.Test;

public class Script04 {

	@Test(groups = {"smoke","regression"})
	public void test08() {
		System.out.println("**** test 08 ****");
		
	}
	
	@Test(groups = "regression")
	public void test09() {
		System.out.println("**** test 09 ****");
		
	}
	
	@Test(groups = "smoke")
	public void test10() {
		System.out.println("**** test 10 ****");
		
	}
}
