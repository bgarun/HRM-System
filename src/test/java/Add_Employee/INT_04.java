package Add_Employee;


import org.testng.annotations.Test;
import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.PomPages.HRAssistEmployeeListPage;
import com.HRMSystem.PomPages.HRAssistant_HomePage;
import com.HRMSystem.PomPages.HRAssitAddEmployeePage;
import com.HRMSystem.PomPages.LoginPage;

public class INT_04 extends BaseClass {

	@Test(groups = "integration")
	public void Script03() throws Throwable {
		
		String UNASST=flib.commonDataFromProperty("unassi");
		String PWDASST=flib.commonDataFromProperty("pwdassi");
		String text = Elib.testDataFromExcel("Sheet4", 2, 0);
		String dept=Elib.testDataFromExcel("Sheet3", 0, 1);
		String branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String file=("C:\\Users\\B G ARUNKUMAR\\Documents\\SP VINAYAK.pdf");
		String img=("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNASST, PWDASST, text);
		Wlib.alertpopupaccept(driver);
		HRAssistant_HomePage AssitHomepage = new HRAssistant_HomePage(driver);
		AssitHomepage.addemployee();
		HRAssistEmployeeListPage empListpage = new HRAssistEmployeeListPage(driver);
		empListpage.addempbtn();
		HRAssitAddEmployeePage addemp = new HRAssitAddEmployeePage(driver);
		addemp.addEmployee(Elib.getList("Sheet1"), driver, dept, branch, file, img);
		Wlib.alertpopupaccept(driver);
		
	}

}
