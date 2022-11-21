package com.HRMSystem.Generic_Libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utilities {
	/**
	 * This Method is used to register and get the connection for the database
	 * @author B G ARUNKUMAR
	 */
	Connection con=null;
public void connectToDB() throws Throwable {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection(IPath_Constants.dbURL, IPath_Constants.dbUsername, IPath_Constants.dbPassword);

}

/**
 * This Method is used to execute query and get data for user
 * @author B G ARUNKUMAR
 * @param query
 * @param columnIndex
 * @param expdata
 * @throws Throwable
 */

public String executeQueryAndGetData(String query, int columnIndex, String expdata, String data) throws Throwable {
	boolean flag = false;
	ResultSet result=con.createStatement().executeQuery(query);
	while(result.next()) {
		data=result.getString(columnIndex);
		if(data.equalsIgnoreCase(expdata)) {
			flag=true;
			break;
		}
	}
	if(flag) {
		System.out.println(data+"____>data verified");
		return expdata;
	}
	else {
		System.out.println(data+"________>Not verified");
		return "";
	}
}
/**
 * This method is used to close the data base
 * @throws SQLException
 */

public void closeDB() throws SQLException {
	con.close();
}
}
