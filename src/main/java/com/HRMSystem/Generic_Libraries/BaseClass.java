package com.HRMSystem.Generic_Libraries;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public DataBase_Utilities dlib =new DataBase_Utilities(); 
	public File_Utilities flib=new File_Utilities();
	public Excel_Utilities Elib=new Excel_Utilities();
	public WebDriver_Utilities Wlib=new WebDriver_Utilities();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite
	public void connectDB() throws Throwable {
		dlib.connectToDB();
	}
	@AfterSuite
	public void closeDB() throws Throwable {
		dlib.closeDB();
	}
	
	//@Parameters("BROWSER")
	@BeforeClass
	public void OpenBrowser() throws Throwable {
		String BROWSER=flib.commonDataFromProperty("browser");
		String URL=flib.commonDataFromProperty("url");
		//WebDriverManager.chromedriver().setup();
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("Invalid Browser");
		}
		
		Wlib.maximizeWindow(driver);
		driver.get(URL);
		Wlib.waitForPageLoad(driver);
		sdriver=driver;
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
scw	bcw	 c;	wj c;w	 c	q c	 c	scl
gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
