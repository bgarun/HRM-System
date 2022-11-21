package Add_Employee;




import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.PomPages.HRAssistEmployeeListPage;
import com.HRMSystem.PomPages.HRAssistantEditEmployeePage;
import com.HRMSystem.PomPages.HRAssistant_HomePage;
import com.HRMSystem.PomPages.HRHead_HomePage;
import com.HRMSystem.PomPages.HROfficerAddEmployeePage;
import com.HRMSystem.PomPages.HROfficerEmployeeListPage;
import com.HRMSystem.PomPages.HROfficer_HomePage;
import com.HRMSystem.PomPages.LoginPage;

public class SYS_01 extends BaseClass{

	@Test(groups = "system")
	public void Script05() throws Throwable {
		
		
		String UNASST=flib.commonDataFromProperty("unassi");
		String PWDASST=flib.commonDataFromProperty("pwdassi");
		String UNHEAD=flib.commonDataFromProperty("unHead");
		String PWDHEAD=flib.commonDataFromProperty("pwdHead");
		String UNOFF = flib.commonDataFromProperty("unoff");
		String PWDOFF =flib.commonDataFromProperty("pwdoff");
		String officer = Elib.testDataFromExcel("Sheet4", 1, 0);
		String dept=Elib.testDataFromExcel("Sheet3", 0, 1);
		String branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String file=("C:\\\\Users\\\\B G ARUNKUMAR\\\\Documents\\\\SP VINAYAK.pdf");
		String img=("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		String Assit=Elib.testDataFromExcel("Sheet4", 2, 0);
		String ID=Elib.testDataFromExcel("Sheet2", 0, 1);
		String head = Elib.testDataFromExcel("Sheet4", 0, 0);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNOFF, PWDOFF, officer);
		Wlib.alertpopupaccept(driver);
		HROfficer_HomePage offhome = new HROfficer_HomePage(driver);
		offhome.addemployee();
		HROfficerEmployeeListPage emplist = new HROfficerEmployeeListPage(driver);
		emplist.addempbtn();
		HROfficerAddEmployeePage addemp = new HROfficerAddEmployeePage(driver);
		addemp.addEmployee(Elib.getList("Sheet1"), driver, dept, branch, file, img);
		Wlib.alertpopupaccept(driver);
		emplist.logout();
		Wlib.alertpopupaccept(driver);
		lp.login(UNASST, PWDASST, Assit);
		Wlib.alertpopupaccept(driver);
		HRAssistant_HomePage assisthome = new HRAssistant_HomePage(driver);
		assisthome.addemployee();
		HRAssistEmployeeListPage assistlist = new HRAssistEmployeeListPage(driver);
		assistlist.editbtn(driver);
		HRAssistantEditEmployeePage empedit = new HRAssistantEditEmployeePage(driver);
		empedit.companyIdtxt(driver,ID, file, img);
		Wlib.alertpopupaccept(driver);
		emplist.logout();
		Wlib.alertpopupaccept(driver);
		lp.login(UNHEAD, PWDHEAD, head);
		Wlib.alertpopupaccept(driver);
		HRHead_HomePage hrhome = new HRHead_HomePage(driver);
		hrhome.employee();
		
	}

}
