package practicePackage;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
		Driver driver= new Driver();
		DriverManager.getConnection("url","un","pwd");
	}

}
