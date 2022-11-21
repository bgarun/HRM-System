 package practicePackage;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions01 {

	
	@Test
	public void create() {
		
		System.out.println("--Line 1---");
		System.out.println("== line 2 ==");
		Assert.assertEquals("A", "B", "Invalid Data");
		System.out.println("== line 3 ==");
		System.out.println("== line 4 ==");
		
	}
	@Test
public void update() {
		
		System.out.println("--Line 5---");
		System.out.println("== line 6 ==");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("A", "B");
		System.out.println("== line 7 ==");
		System.out.println("== line 8 ==");
		sa.assertAll();
		
	}
	
	@Test
	public void delete() {
			String a="TestYantra";
			String b="QSpiders";
			System.out.println("--Line 9---");
			System.out.println("== line 10 ==");
			assertTrue(a.equals(b));
			System.out.println("== line 11 ==");
			System.out.println("== line 12 ==");
			
		}
	
	@Test
	public void edit() {
			String a=null;
			String b="QSpiders";
			System.out.println("--Line 13---");
			System.out.println("== line 14 ==");
			assertNull(b);
			System.out.println("== line 15 ==");
			System.out.println("== line 16 ==");
				
		}
}
