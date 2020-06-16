package com.my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	private final static String className = "oracle.jdbc.driver.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@192.168.0.107:1521:xe";;
	private final static String user ="test";
	private final static String password = "test";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		con = DriverManager.getConnection(url, user, password);
		Class.forName(className);
		System.out.println("JDBC 드라이버 로드 성공");
		return con;
	}
	public static void close(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
	public static void close(Statement statement, Connection connection) throws SQLException {
		if(statement != null) {
			statement.close();
		}
		close(connection);
	}
	public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		close(statement, connection);
	}
}
