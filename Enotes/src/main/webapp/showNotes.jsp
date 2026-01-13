<%@page import="com.user.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
User user3 = (User) session.getAttribute("userD");

if (user3 == null) {
	session.setAttribute("loginMsg", "Please Login First");
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_componet/allcss.jsp"%>
</head>
<body>
	<%@include file="all_componet/navbar.jsp"%>

	<div class="container">
		<h2 class="text-center">All Notes:</h2>
		<div class="row">
			<div class="col-md-12">



				<%
				if (user3 != null) {

					PostDAO pd = new PostDAO(DBConnect.getConn());
					List<Post> post = pd.getData(user3.getId());
				
					for (Post po : post) {
				%>
				<div class="card mt-3">
					<img alt="" src="img/paper.png" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">

					<div class="card-body p-4">




						<h5 class="card-title"><%=po.getTitle() %></h5>
						<p><%=po.getContent() %></p>

						<p>
							<b class="text-success">Published By:<%=user3.getName() %></b></br> <b class="text-primary"></b>
						</p>
						<p>
							<b class="text-success">Published Date:<%=po.getDate() %></b></br> <b
								class="text-success"></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=po.getId() %>" class="btn btn-danger">Delete</a> 
							
							<a href="edit.jsp?note_id=<%=po.getId() %>"
								class="btn btn-primary">Edit</a>

						</div>


					</div>

				</div>

				<%
				}
				}
				%>



			</div>

		</div>


	</div>

	<%@include file="all_componet/footer.jsp"%>
</body>
</html>