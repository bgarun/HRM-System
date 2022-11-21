package practicePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//Step1:get java representation object of physical file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		//step2:Create object for properties class
		Properties pObj=new Properties();
		//step3:Load the keys
		pObj.load(fis);
		//step4: get the value using getproperty
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String UNHEAD=pObj.getProperty("unHead");
		String PWDHEAD=pObj.getProperty("pwdHead");
		String UNOFF=pObj.getProperty("unoff");
		String PWDOFF=pObj.getProperty("pwdoff");
		String UNASSIST=pObj.getProperty("unassi");
		String PWDASSIST=pObj.getProperty("pwdassi");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UNHEAD);
		System.out.println(PWDHEAD);
		System.out.println(UNOFF);
		System.out.println(PWDOFF);
		System.out.println(UNASSIST);
		System.out.println(PWDASSIST);
		
		
		// Launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.err.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);
		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);
		WebElement dropdown = driver.findElement(By.id("hr_type"));
		Select s=new Select(dropdown);
		dropdown.click();
		s.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		driver.switchTo().alert().accept();
		
		
		
	}

}
