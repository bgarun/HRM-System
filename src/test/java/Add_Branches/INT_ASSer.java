package Add_Branches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.HRMSystem.Generic_Libraries.IPath_Constants;

public class INT_ASSer {

	public static void main(String[] args) throws Throwable {
FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);

	
		String URL=pObj.getProperty("url");
		String UNHEAD=pObj.getProperty("unHead");
		String PWDHEAD=pObj.getProperty("pwdHead");
		
		WebDriver driver=new ChromeDriver();
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
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
		driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
		
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		FileInputStream fi =new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("employee_companyid");
		list.add("employee_firstname");
		list.add("employee_lastname");
		list.add("employee_middlename");
		list.add("branches_datefrom");
		list.add("branches_recentdate");
		list.add("employee_position");
		list.add("employee_contact");
		list.add("employee_sss");
		list.add("employee_tin");
		list.add("employee_hdmf_pagibig");
		list.add("employee_gsis");
		for(int i=1;i<=count;i++) {
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(list.get(i-1))).sendKeys(value);
		}
		WebElement dept = driver.findElement(By.name("employee_department"));
		Select d=new Select(dept);
		d.selectByVisibleText("Basavanagudi");
		
		WebElement branch = driver.findElement(By.name("employee_branches"));
		Select b=new Select(branch);
		b.selectByVisibleText("Bengaluru");
		
		
		driver.findElement(By.name("employee_file201")).sendKeys("C:\\Users\\B G ARUNKUMAR\\Documents\\SP VINAYAK.pdf");
		driver.findElement(By.name("employee_image")).sendKeys("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		driver.findElement(By.name("emplo")).click();
		driver.switchTo().alert().accept();
		
	
		
		
		
		
		
		
	}

}
