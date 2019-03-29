<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/manageproducts.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/manageproducts.css" />
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/newProduct" method="post">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath}">O</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Shopping Cart</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">My Account<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">My Orders</a></li>
							<li><a href="#">Manage Orders</a></li>
							<li><a
								href="${pageContext.request.contextPath}/manageProduct">Manage
									Products</a></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
		
		<!-- Displaying Button and tables starts -->
		
		<div align="center">
			<div class="container">
				<button type="submit" class="btn btn-primary">New Product</button>
			</div>
			<br />
			<div class="container">
				<input type="text" class="form-control" id="myInput"
					onkeyup="myFunction()" placeholder="Search for names..">
			</div>

			<div class="container">

				<table class="table" id="myTable">
					<thead>
						<tr>
							<th>Title</th>
							<th>Price</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${ product.title }</td>
							<td>${ product.price }</td>
							<td><a href="${pageContext.request.contextPath}/newProduct/${product.id }">Edit</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
			<!-- Displaying Button and tables Ends -->
	</form:form>


</body>
</html>
