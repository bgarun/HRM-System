package Add_Corporate;

import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.PomPages.EmployeeListPage;
import com.HRMSystem.PomPages.HRHead_HomePage;
import com.HRMSystem.PomPages.LoginPage;

public class MvnTest extends BaseClass{

	
	@Test
	public void Script01() throws Throwable {
		
		String UNHEAD=flib.commonDataFromProperty("unHead");
		String PWDHEAD=flib.commonDataFromProperty("pwdHead");
		String head = Elib.testDataFromExcel("Sheet4", 0, 0);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNHEAD, PWDHEAD, head);
		Wlib.alertpopupaccept(driver);
		HRHead_HomePage hr=new HRHead_HomePage(driver);
		hr.employee();
		EmployeeListPage elp = new EmployeeListPage(driver);
		elp.deletebtn(driver, Wlib);
		Wlib.alertpopupaccept(driver); 
		
		
	}
}
