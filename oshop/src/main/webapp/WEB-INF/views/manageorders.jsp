<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form>
<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath}">O</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${pageContext.request.contextPath}/shoppingcart">Shopping Cart</a></li>
					<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="">My Account
					<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/myorder">My Orders</a></li>
							<li><a href="${pageContext.request.contextPath}/manageOrder">Manage Orders</a></li>
							<li><a href="${pageContext.request.contextPath}/manageProduct">Manage Products</a></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>	
</form:form>
</body>
</html>