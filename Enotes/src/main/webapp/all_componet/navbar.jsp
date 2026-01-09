<%@page import="com.user.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
	<a class="navbar-brand" href="#"><i class="fa fa-book"
		aria-hidden="true"></i> ENotes</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fa fa-home" aria-hidden="true"></i> Home <span
					class="sr-only">(curresnt)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#"><i
					class="fa fa-plus" aria-hidden="true"></i> Add Notes</a></li>
			<li class="nav-item"><a class="nav-link"><i
					class="fa fa-file-text-o" aria-hidden="true"></i> Show Notes</a></li>
		</ul>

		<%
		User user = (User) session.getAttribute("userD");
		if (user != null) {
		%>
		<a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-2"
			type="submit"><i class="fa fa-user" aria-hidden="true"></i> <%=user.getName()%></a>
		<a href="register.jsp" class="btn btn-light my-2 my-sm-0"
			type="submit"><i class="fa fa-user-plus" aria-hidden="true"></i>
			Logout</a>
		<%
		} else {
		%>
		<a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-2"
			type="submit"><i class="fa fa-user" aria-hidden="true"></i> Login</a>
		<a href="register.jsp" class="btn btn-light my-2 my-sm-0"
			type="submit"><i class="fa fa-user-plus" aria-hidden="true"></i>
			Register</a>
		<%
		}
		%>


	</div>
</nav>