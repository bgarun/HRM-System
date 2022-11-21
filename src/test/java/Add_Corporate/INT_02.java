package Add_Corporate;



import org.testng.annotations.Test;
import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.PomPages.HRAssistEmployeeListPage;
import com.HRMSystem.PomPages.HRAssistant_HomePage;
import com.HRMSystem.PomPages.HRAssitAddEmployeePage;
import com.HRMSystem.PomPages.LoginPage;

public class INT_02 extends BaseClass{

	@Test(groups = {"integration"})
	public void Script02() throws Throwable {
		
		String UNASST=flib.commonDataFromProperty("unassi");
		String PWDASST=flib.commonDataFromProperty("pwdassi");
		String Assit=Elib.testDataFromExcel("Sheet4", 2, 0);
		String dept=Elib.testDataFromExcel("Sheet3", 0, 1);
		String branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String file=("C:\\\\Users\\\\B G ARUNKUMAR\\\\Documents\\\\SP VINAYAK.pdf");
		String img=("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNASST, PWDASST, Assit);
		Wlib.alertpopupaccept(driver);
		HRAssistant_HomePage ha = new HRAssistant_HomePage(driver);
		ha.addemployee();
		HRAssistEmployeeListPage hal = new HRAssistEmployeeListPage(driver);
		hal.addempbtn();
		HRAssitAddEmployeePage hae = new HRAssitAddEmployeePage(driver);
	    hae.addEmployee(Elib.getList("Sheet1"), driver, dept, branch, file, img);
		Wlib.alertpopupaccept(driver);
		
		
	}
	@Test(groups = {"integration"})
	public void regration() {
		System.out.println("Testing the Regional testing");
	}
	
	

}
