package Add_Corporate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.Generic_Libraries.Excel_Utilities;
import com.HRMSystem.Generic_Libraries.File_Utilities;
import com.HRMSystem.Generic_Libraries.WebDriver_Utilities;
import com.HRMSystem.PomPages.AddEmployeePage;
import com.HRMSystem.PomPages.EmployeeListPage;
import com.HRMSystem.PomPages.HRHead_HomePage;
import com.HRMSystem.PomPages.HROfficer_HomePage;
import com.HRMSystem.PomPages.LoginPage;

public class INT_03 extends BaseClass{

	@Test(groups = {"integration"})
	public void Script03() throws Throwable {
		
		String UNHEAD=flib.commonDataFromProperty("unHead");
		String PWDHEAD=flib.commonDataFromProperty("pwdHead");
		String UNOFF = flib.commonDataFromProperty("unoff");
		String PWDOFF =flib.commonDataFromProperty("pwdoff");
		String text = Elib.testDataFromExcel("Sheet4", 0, 0);
		String officer = Elib.testDataFromExcel("Sheet4", 1, 0);
		String dept=Elib.testDataFromExcel("Sheet3", 0, 1);
		String branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String file=("C:\\\\Users\\\\B G ARUNKUMAR\\\\Documents\\\\SP VINAYAK.pdf");
		String img=("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNHEAD, PWDHEAD, text);
		Wlib.alertpopupaccept(driver);
		HRHead_HomePage hrhome = new HRHead_HomePage(driver);
		hrhome.employee();
		EmployeeListPage emplist = new EmployeeListPage(driver);
		emplist.addempbtn();
		AddEmployeePage addemp = new AddEmployeePage(driver);
		addemp.addEmployee(Elib.getList("Sheet1"), driver, dept, branch, file, img);
		Wlib.alertpopupaccept(driver);
		EmployeeListPage logout = new EmployeeListPage(driver);
		logout.logout();
		Wlib.alertpopupaccept(driver);
		lp.login(UNOFF, PWDOFF, officer);
		Wlib.alertpopupaccept(driver);
		HROfficer_HomePage offHomepage = new HROfficer_HomePage(driver);
		offHomepage.addemployee();

	}

}
