package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.com.my.sql.MyConnection;

public class MyConnectionTest {
	public static void main(String[] args) {
		Connection con = null;

		try {
			con = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			MyConnection.close(rs, stmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
