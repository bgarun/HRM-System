package com.HRMSystem.Generic_Libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utilities {
	/**
	 * This method is used to read data from Property file
	 * @author B G ARUNKUMAR
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
public String commonDataFromProperty(String key) throws Throwable {
	FileInputStream fis = new FileInputStream(IPath_Constants.FilePath);
	
	Properties pObj=new Properties();
	pObj.load(fis);

	String value=pObj.getProperty(key);
	return value;
	
}
}
