package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.Excel_Utilities;

public class ExcelDataProvider {
	
	
	@Test(dataProvider="getData")
	public void travelling(String src, String dst) {
		System.out.println(src+"----->>"+dst);
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		Excel_Utilities elib = new Excel_Utilities();
		Object[][] value = elib.readDataFromDataProvider("Data");
		return value;
	}
}
