package practicePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryinDataBaseTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
		Statement stat = con.createStatement();
		String query = "insert into employee values ('Viresh','Mechanical','Haveri',9586452315);";
		int result = stat.executeUpdate(query);
		if(result==1) {
			System.out.println("Data base is updated");
		}
		else {
			System.err.println("Data base updation is failed");
		}
		con.close();
	}

}
