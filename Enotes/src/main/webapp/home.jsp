<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_componet/allcss.jsp"%>
</head>
<body>

	<div class="container-fluid p-0">
		<%@include file="all_componet/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="img/paper.png" class="img-fluid mx-auto"
					style="max-width: 300px;">
				<h1>Start Taking Your Notes</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>
	<%@include file="all_componet/footer.jsp" %>
</body>
</html>