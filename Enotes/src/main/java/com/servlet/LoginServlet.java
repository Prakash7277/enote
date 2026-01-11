package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.user.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String email = req.getParameter("uemail");
		String pass = req.getParameter("upass");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(pass);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		User us = dao.loginUser(user);
		
		if(us!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("userD", us);
			resp.sendRedirect("home.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("login-failed","Invalid Email And Password");
			resp.sendRedirect("login.jsp");
		}
		
	}

}
