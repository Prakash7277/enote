package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.PostDAO;
import com.db.DBConnect;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer noteid = Integer.parseInt( request.getParameter("note_id"));
			PostDAO post = new PostDAO(DBConnect.getConn());
			boolean f = post.deleteById(noteid);
			if(f) {
				System.out.print("User Are Delete");
				response.sendRedirect("showNotes.jsp");
			}else {
				System.out.print("User not Delete");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
