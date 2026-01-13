package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<Post> getData(int id){
		List<Post> list =new ArrayList<Post>();
		
		try {
			String q = "select * from post where uid=? order by id DESC";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt(1));
				System.out.print(rs.getString(2));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
				post.setDate(rs.getTimestamp(4));
				list.add(post);
			}
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
		return list;
	}
	
	public Post getDataById(int noteId) {
		Post p = null;
		try {
			String q ="select * from post where id=?";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p=new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	
	public Boolean updateData (int nid, String ti ,String co){
		 boolean f = false;
		 try {
			 String update = "update post set title =? , content=? where id=? ";
			 PreparedStatement ps = conn.prepareStatement(update);
			 ps.setString(1, ti);
			 ps.setString(2, co);
			 ps.setInt(3, nid);
			 int i=ps.executeUpdate();
			 if(i==1) {
				 f=true;
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return f;
	}
	public Boolean deleteById(int id) {
		boolean f = false;
		try {
			String qu = "delete from post where id=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
