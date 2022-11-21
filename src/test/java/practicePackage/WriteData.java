package practicePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData {

	public static void main(String[] args) throws Throwable, IOException {
		//create object for physical file
		FileInputStream fi=new FileInputStream("src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		String a[] = {"Accounting","HR","Management","Security","Sales"};
		for (int i = 0; i <a.length; i++) {
			book.getSheet("Sheet1").createRow(i).createCell(2).setCellValue(a[i]);
			FileOutputStream fos = new FileOutputStream("src\\test\\resources\\TestData.xlsx");
			book.write(fos);
		}
		
		
	}
}
