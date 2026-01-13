package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.PostDAO;
import com.db.DBConnect;


@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer noteid = Integer.parseInt( request.getParameter("note_id"));
			String title=request.getParameter("title");
			String content = request.getParameter("content");
			
			PostDAO pd = new PostDAO(DBConnect.getConn()) ;
			boolean f = pd.updateData(noteid, title, content);
			if(f) {
				System.out.println("Data Update");
				response.sendRedirect("showNotes.jsp");
			}else {
				System.out.println("Data Not Update");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
