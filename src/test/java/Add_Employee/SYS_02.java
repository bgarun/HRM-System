package Add_Employee;


import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.BaseClass;
import com.HRMSystem.PomPages.AddBranchPage;
import com.HRMSystem.PomPages.AddCorporatePage;
import com.HRMSystem.PomPages.AddEmployeePage;
import com.HRMSystem.PomPages.BranchListPage;
import com.HRMSystem.PomPages.CorporateListPage;
import com.HRMSystem.PomPages.EmployeeListPage;
import com.HRMSystem.PomPages.HRHead_HomePage;
import com.HRMSystem.PomPages.LoginPage;


public class SYS_02 extends BaseClass{

	@Test(groups = "system")
	public void script06() throws Throwable {
		
		
		String UNHEAD=flib.commonDataFromProperty("unHead");
		String PWDHEAD=flib.commonDataFromProperty("pwdHead");
		String head = Elib.testDataFromExcel("Sheet4", 0, 0);
		String Corp=Elib.testDataFromExcel("Sheet3", 0, 1);
		String Branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String dept=Elib.testDataFromExcel("Sheet3", 0, 1);
		String branch=Elib.testDataFromExcel("Sheet3", 1, 1);
		String file=("C:\\\\Users\\\\B G ARUNKUMAR\\\\Documents\\\\SP VINAYAK.pdf");
		String img=("C:\\Users\\B G ARUNKUMAR\\Pictures\\Screenshots\\Screenshot (611).png");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(UNHEAD, PWDHEAD, head);
		Wlib.alertpopupaccept(driver);
		HRHead_HomePage hrhome = new HRHead_HomePage(driver);
		hrhome.corporate();
		CorporateListPage corpPage = new CorporateListPage(driver);
		corpPage.addcorporatebtn();
		AddCorporatePage addcorp = new AddCorporatePage(driver);
		addcorp.addcorporate(Corp);
		Wlib.alertpopupaccept(driver);
		hrhome.branch();
		BranchListPage branchlist = new BranchListPage(driver);
		branchlist.addbranchbtn();
		AddBranchPage addbranch = new AddBranchPage(driver);
		addbranch.branchtxt(Branch);
		Wlib.alertpopupaccept(driver);
		hrhome.employee();
		EmployeeListPage emplist = new EmployeeListPage(driver);
		emplist.addempbtn();
		AddEmployeePage addemp = new AddEmployeePage(driver);
		addemp.addEmployee(Elib.getList("Sheet1"), driver, dept, branch, file, img);
		Wlib.alertpopupaccept(driver);
		
	}

}
