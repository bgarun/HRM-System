package practicePackage;

import org.testng.annotations.Test;

import com.HRMSystem.Generic_Libraries.Excel_Utilities;

public class ExcelDataProvider02 {

	@Test(dataProviderClass=ExcelDataProviderMethod02.class, dataProvider="readDataProvider")
	public void name(String name, String price) {
		System.out.println(name+"---->>"+price);
	}
	
}
