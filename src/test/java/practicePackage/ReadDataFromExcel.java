package practicePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static void main(String[] args) throws Throwable, IOException {
		//create object for physical file
		FileInputStream fi=new FileInputStream("src\\test\\resources\\TestData.xlsx");
		//create workbook
		Workbook wb = WorkbookFactory.create(fi);
		for(int i=1; i<=5;i++) {
		String DeptName = wb.getSheet("sheet1").getRow(i).getCell(1).getStringCellValue();
		System.out.println(DeptName);
		}
		
		
		
	
		
		
		
	}

}
