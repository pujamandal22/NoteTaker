<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.helper.*"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>


		<h1 class="text-uppercase">All notes:</h1>
		<div class="row">
			<div class="col-md-12">
				<%
					Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note n : list) {
				%>

				<div class="card mt-3" >
					<img class="card-img-top mx-auto" src="images/notes.png" style="height: 60px;width:60px;margin:10px;" alt="Card image cap" >
					<div class="card-body px-5">
						<h5 class="card-title"><%=n.getTitle() %></h5>
						<p class="card-text">
						<%=n.getContent() %>
						</p>
						
						<div class="container text-center mt-2">
						<a href="DeleteServlet?note_id<%=n.getId() %>" class="btn btn-danger">Delete</a>
						<a href="#" class="btn btn-success" style="width:80px;">Edit</a>
						</div>
					</div>
				</div>
				<%
					}

				s.close();
				%>
			</div>
		</div>


	</div>
</body>
</html>