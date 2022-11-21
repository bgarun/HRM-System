 package practicePackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest {
	
	final static int count=2;
@Test(priority=0, invocationCount = count )
public void addEmp() 
{
	
	System.out.println("employee added");
}

@Test(priority=1, invocationCount = 0, enabled=true)
public void editEmp() 
{
	int[] ar= {1,2,3};
	System.err.println("employee Edited");
	System.out.println(ar[1]);
	//Assert.fail();
}


@Test(priority=-1, invocationCount = 1)
public void addCorp() 
{
	System.out.println("Corporate added");
}

@Test(priority=-1, invocationCount = -2, enabled=true)
public void editCorp() 
{
	System.out.println("Corporate Edited");
}
}
