package practicePackage;

import org.testng.annotations.Test;

public class Script01 {
	
@Test(groups = "smoke")
public void test01() {
	System.out.println("**** test 01 ****");
	
}

@Test(groups = "regression")
public void test02() {
	System.out.println("**** test 02 ****");
	
}


@Test
public void test03() {
	System.out.println("**** test 03 ****");
	
}
}
