 package dao;

import dbutil.DBUtil;
import pojo.LoginInfo;
import java.sql.*;
import java.sql.Statement;

public class LoginDAO {
	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM LOGIN_INFO WHERE USER_NAME = '"+userDetails.getUserName()+"' AND PASSWORD = '"+userDetails.getPassword()+"'");
				while(rs.next())
					validStatus = true;
				DBUtil.closeConnection(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return validStatus;
	}

}
