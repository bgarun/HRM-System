package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBaseTest {

	public static void main(String[] args) throws SQLException {
		Driver driver= new Driver();
		
		//step1:Register the data base
		DriverManager.registerDriver(driver);
		//step2:Get connection for data base
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
		//step3:issue create statement
		Statement stat = con.createStatement();
		String query = "select * from employee;";
		//step4: Execute query
		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		//step5:close data base connection
		con.close();

}
}
