<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Register Page</title>
<%@include file="all_componet/allcss.jsp"%>
</head>
<body>
	<%@include file="all_componet/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x"></i>
						<h4 class="mt-2">Registration</h4>
					</div>
					<%
						String regMsg = (String)session.getAttribute("reg-sucess");
						if(regMsg!=null){
					%>
					<div class="alert alert-success" role="alert"><%= regMsg %> Login <a href="login.jsp"> Chick Here</a></div>
					<%	
					session.removeAttribute("reg-sucess");
						}
					%>
					
					<%
						String FaildMsg = (String)session.getAttribute("failed-msg");
						if(FaildMsg!=null){
					%>
				<div class="alert alert-danger" role="alert"><%=FaildMsg %></div>
					<%	
					session.removeAttribute("failed-msg");
						}
					%>
					
						
					<div class="card-body">
						<form action="UserServlet" method="post">

							<div class="form-group">
								<label>Enetr Full Name</label> <input type="text" name="uname"
									class="form-control" placeholder="Enter email" required>
							</div>

							<!-- Email -->
							<div class="form-group">
								<label>Email address</label> <input type="email" name="uemail"
									class="form-control" placeholder="Enter email" required>
							</div>

							<!-- Password -->
							<div class="form-group">
								<label>Password</label> <input type="password" name="upassword"
									class="form-control" placeholder="Enter password" required>
							</div>

							<!-- Submit -->
							<button type="submit" class="btn btn-primary btn-block">
								Register</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<%@include file="all_componet/footer.jsp"%>
</body>
</html>