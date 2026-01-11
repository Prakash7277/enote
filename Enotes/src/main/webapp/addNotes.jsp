<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		User user1 =(User) session.getAttribute("userD");
		if(user1==null){
			response.sendRedirect("login.jsp");
			session.setAttribute("Login-error", "Please Login..");
		}
	%>
	
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_componet/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="all_componet/navbar.jsp"%>
		<h1 class="text-center">Add Your Notes</h1>
		<div class="container">

			<div class="row">
				<div class="col-md-12">

					<form action="AddNotesServlet" method="post">
						<div class="form-group">
						
						<% 
							User us =(User)session.getAttribute("userD");
						
						%>
						<%
						if(us!=null){
						%>
						
						<input type="hidden" value="<%=us.getId() %>" name="uid">
						<%} %>
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" name="title" class="form-control" id="exampleInputEmail1" 
								aria-describedby="emailHelp" placeholder="Enter here" required="required">

						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content" placeholder="Enter Your Content" required="required"></textarea>
						</div>
						<div class="conteiner text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>

				</div>

			</div>

		</div>

	</div>
	<%@include file="all_componet/footer.jsp" %>
</body>
</html>