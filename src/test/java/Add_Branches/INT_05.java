package Add_Branches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class INT_05 {

	public static void main(String[] args) throws Throwable {
FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);

		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String UNHEAD=pObj.getProperty("unHead");
		String PWDHEAD=pObj.getProperty("pwdHead");
		WebDriverManager.chromedriver().setup();
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
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("hr_email")).sendKeys(UNHEAD);
		driver.findElement(By.name("hr_password")).sendKeys(PWDHEAD);
		WebElement dropdown = driver.findElement(By.id("hr_type"));
		Select s=new Select(dropdown);
		dropdown.click();
		s.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("//p[text()='Add Braches']")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath("(//button[@class='btn btn-danger btn-sm'])[10]")).click();
		Thread.sleep(2000);
		WebDriverWait w= new WebDriverWait(driver, 30);
		WebElement delete = driver.findElement(By.xpath("(//button[@type='submit'])[45]"));
		w.until(ExpectedConditions.elementToBeClickable(delete));
		delete.click();
		
		//driver.findElement(By.name("braches")).click();
		driver.switchTo().alert().accept();
		

	}

}
