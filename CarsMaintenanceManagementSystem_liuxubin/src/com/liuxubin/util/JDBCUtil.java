package com.liuxubin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static String url="jdbc:mysql://localhost:3306/cmms";
	private static String username="root";
	private static String password="123456";
	private static String driverName="com.mysql.jdbc.Driver";
	
	public Connection getConnection() throws Exception {
		Class.forName(driverName);
	    Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	    
	}
	
	public void closeCon(Connection conn) throws Exception {			
			if (conn!=null) {
				conn.close();
			}
	}
	public static void main(String[] args) {
		JDBCUtil jdbc=new JDBCUtil();
		try {
			jdbc.getConnection();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("连接失败");
		}
	}
}
