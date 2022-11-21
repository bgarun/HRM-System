package Add_Corporate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_corp_to_Dashboard {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);

		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String UNHEAD=pObj.getProperty("unHead");
		String PWDHEAD=pObj.getProperty("pwdHead");
		
		FileInputStream fi=new FileInputStream("src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		String DeptName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		
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
		
		driver.findElement(By.xpath("(//a[@class=\"nav-link\"])[3]")).click();
		driver.findElement(By.xpath("//p[text()='Add Corporate']")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		driver.findElement(By.name("corporate_name")).sendKeys(DeptName);
		driver.findElement(By.name("corp")).click();
	
		driver.switchTo().alert().accept();
		driver.findElement(By.id("example1_next")).click();
		String expected = "Production";
		
		
		
		}

	}


