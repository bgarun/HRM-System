package practicePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationExecution {

	@BeforeMethod
	public void congfMethod() {
		System.out.println("Login to the application");
	}
	@BeforeClass
	public void congfclass() {
		System.out.println("Launch the Browser");
	}
	@BeforeSuite
	public void congfSuit() {
		System.out.println("Connect to the Data Base");
	}
	@Test
	public void congfTest() {
		System.out.println("Test Script");
	}
	@AfterClass
	public void congfclss() {
		System.out.println("Close the Browser");
	}
	@AfterMethod
	public void congfMthd() {
		System.out.println("Logout from application");
	}
	@AfterSuite
	public void congfSt() {
		System.out.println("Close DataBase");
	}
}
