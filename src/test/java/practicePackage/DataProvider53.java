package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider53 {
	
	@Test(dataProvider="getData")
	public void travelling(String src, String dst, int price) {
		System.out.println(src+"----->>"+dst+" , "+price);
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] obj=new Object[5][3];
		obj[0][0]="Bengaluru";
		obj[0][1]="Goa";
		obj[0][2]=100;
		
		obj[1][0]="Goa";
		obj[1][1]="Bengaluru";
		obj[1][2]=150;
		
		obj[2][0]="Hubli";
		obj[2][1]="Mangaluru";
		obj[2][2]=170;
		
		obj[3][0]="Gadag";
		obj[3][1]="Mysore";
		obj[3][2]=250;
		
		obj[4][0]="Belagavi";
		obj[4][1]="Gadag";
		obj[4][2]=120;
		return obj;
		
	}
	
}

