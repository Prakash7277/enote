package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;
	public static Connection getConn() {
		
		try {
			
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","");
			System.out.println(conn);
			}
		} catch (Exception e) {
			System.out.println("ex::"+e.getMessage());
		}
		
		return conn;
	}
}
