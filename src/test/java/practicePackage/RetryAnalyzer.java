package practicePackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {
	
@Test(retryAnalyzer=com.HRMSystem.Generic_Libraries.RetryImplementation.class)
public void retry() {
	System.out.println("=== Script 01 ===");
	System.out.println("=== Script 02 ===");
	Assert.fail();
	System.out.println("=== Script 03 ===");
	System.out.println("=== Script 04 ===");
}
}
