package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
 
	public static Connection getConnection() {
		 
		Connection con = null;
		try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
			    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		return con;
		
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
