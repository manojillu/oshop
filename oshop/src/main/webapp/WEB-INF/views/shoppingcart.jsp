<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/shoppingcart.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/shoppingcart.js"></script>
</head>
<body>
	<form:form>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="${pageContext.request.contextPath}">O</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/shoppingcart">Shopping
							Cart <span id="quantity" class="badge"> <c:out
									value="${quantity}"></c:out>
						</span> <!-- id="quantity" -->
					</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">My Account <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/myorder">My
									Orders</a></li>
							<li><a href="${pageContext.request.contextPath}/manageOrder">Manage
									Orders</a></li>
							<li><a
								href="${pageContext.request.contextPath}/manageProduct">Manage
									Products</a></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div class="container">

			<table class="table" id="myTable">
				<thead>
					<tr>
						<th>Product</th>
						<th>Title</th>
						<th>Price</th>
						<th>Quantity</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td><a target="_blank" href=""> <img
									src="${product.imageUrl}" alt="Forest" style="width: 150px">
							</a></td>
							<td>${ product.title }</td>
							<td>${ product.price }</td>
							<td>
								<div class="input-group" id="${product.id}">
									<span class="input-group-btn">
										<a onclick="decreaseQuantity(${product.id})"
											class="quantity-left-minus btn btn-danger btn-number"
											data-type="minus" data-field="">
											<span class="glyphicon glyphicon-minus"></span>
										</a>
									</span> <input type="number" id="quantity${product.id}" name="quantity" 
										class="form-control input-number" value="${product.quantity}" min="1" max="20">
									<span class="input-group-btn">
										<a onclick="increaseQuantity(${product.id})"
											class="quantity-right-plus btn btn-success btn-number"
											data-type="plus" data-field="">
											<span class="glyphicon glyphicon-plus"></span>
										</a>
									</span>
								</div>
							</td>
							<td><a
								href="${pageContext.request.contextPath}/newProduct/${product.id }">Delete
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
</body>
</html>