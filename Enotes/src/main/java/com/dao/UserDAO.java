package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.User;

public class UserDAO {
	
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser (User us) {
		boolean f = false;
		
		try {
			String query ="insert into users(name,email,password) values (?,?,?)";
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			 int i=ps.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}
	
	public User loginUser(User user) {
		User us = null;
		try {
			String query = "select * from users where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				us = new User();
				us.setName(rs.getString("name"));
				us.setEmail(rs.getString("email"));
				us.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			
		}
		return us;
		
	}
}
