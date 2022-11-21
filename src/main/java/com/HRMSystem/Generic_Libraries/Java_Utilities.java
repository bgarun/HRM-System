package com.HRMSystem.Generic_Libraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Java_Utilities {
	/**
	 * This Method is used to get random numbers
	 * @author B G ARUNKUMAR
	 * @return
	 */
public int getRandomNumber() {
	Random ran=new Random();
	int random = ran.nextInt(10000);
	return random;
	
}
/**
 * This method is used to get system date
 * @author B G ARUNKUMAR
 * @return
 */

public String getSystemDate() {
	Date date=new Date();
	String systemdate=date.toString();
	return systemdate;
}

/**
 * This method is used to get System Date and Time in format
 * @author B G ARUNKUMAR
 * @return
 */
public String getSystemDateInFormat() {
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	Date systemdate = new Date();
	String getDateAndTime = dateformat.format(systemdate);
	return getDateAndTime.replaceAll(":", "-");
}

}
