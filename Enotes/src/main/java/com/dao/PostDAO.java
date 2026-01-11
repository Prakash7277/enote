package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.user.Post;

public class PostDAO {

	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addNotes(String ti , String co , int ui) {
		boolean f = false;
	
		
		try {
			String que= "insert into post(title,content,uid) values(?,?,?)";
			
			PreparedStatement psr=conn.prepareStatement(que);
			psr.setString(1,ti);
			psr.setString(2,co);
			psr.setInt(3, ui);
			
			int i = psr.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return f;
		
	}
}
