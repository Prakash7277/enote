package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import com.user.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.user.*;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("uname");
		String email = req.getParameter("uemail");
		String password = req.getParameter("upassword");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(user);
//		PrintWriter out = resp.getWriter();
		HttpSession session;

		if(f) {
			session = req.getSession();
			session.setAttribute("reg-sucess", "Registration Sucessfully..");
			resp.sendRedirect("register.jsp");
//			out.print("User Register successfully");
		}else {
//			out.print("data not Insert...");
			session = req.getSession();
			session.setAttribute("failed-msg","Something went wrong on server");
			resp.sendRedirect("register.jsp");
		}
		
		
	}
}
