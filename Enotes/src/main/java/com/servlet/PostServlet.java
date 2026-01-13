package com.servlet;

import java.io.IOException;

import com.dao.PostDAO;
import com.db.DBConnect;
import com.user.Post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNotesServlet")
public class PostServlet extends HttpServlet {

	Post post =new Post();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");


		PostDAO dao = new PostDAO(DBConnect.getConn());

		boolean f = dao.addNotes(title, content, uid);
		if(f) {
			System.out.println("Data insert Sucessfully");
			resp.sendRedirect("showNotes.jsp");
		}else {
			System.out.println("Something is Wrong....");
		}

	}
}
