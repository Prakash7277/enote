<%@page import="com.user.Post"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
User user1 = (User) session.getAttribute("userD");

if (user1 == null) {
    session.setAttribute("loginMsg", "Please Login First");
    response.sendRedirect("login.jsp");
    return; 
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<%@include file="all_componet/allcss.jsp"%>
</head>
<body>

<%
Integer noteid = Integer.parseInt( request.getParameter("note_id"));

PostDAO post = new PostDAO(DBConnect.getConn());
Post p = post.getDataById(noteid);

%>

	<%@include file="all_componet/navbar.jsp"%>
	<div class="container-fluid">

		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">

			<div class="row">
				<div class="col-md-12">

					<form action="NoteEditServlet" method="post">
					
					<input type="hidden" name="note_id" value="<%=noteid %>">
					
						<div class="form-group">

							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" name="title" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Enter here" required="required" value="<%=p.getTitle()%>">

						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" class="form-control" name="content" required="required"><%=p.getContent() %></textarea>

						</div>
						<div class="conteiner text-center">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>
	<%@include file="all_componet/footer.jsp"%>
</body>
</html>