<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/newproduct.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/newproduct.css" />
</head>
<body>

	<form:form
		action="${pageContext.request.contextPath}/saveProduct/${id }"
		method="post">
		<!-- Fixed Nav Bar -->
		<div>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="${pageContext.request.contextPath}">O</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a
							href="${pageContext.request.contextPath}/shoppingcart">Shopping
								Cart</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="">My Account <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/myorder">My
										Orders</a></li>
								<li><a
									href="${pageContext.request.contextPath}/manageOrder">Manage
										Orders</a></li>
								<li><a
									href="${pageContext.request.contextPath}/manageProduct">Manage
										Products</a></li>
								<li><a href="#">Logout</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</div>

		<!-- Fixed Nav Bar Ends -->

		<!-- Adding Products Starts -->

		<div class="row">
			<!-- Column 1  -->
			<div class="column">

				<div class="form-group">
					<label for="title">Title:</label> <input type="text"
						class="form-control" id="title" name="title"
						value="${editproduct.title}"/>
					<div>
						<p id="isTitleRequired" class = "alert alert-danger">Title cannot be empty</p>
					</div>
				</div>
				<div class="form-group">
					<label for="price">Price:</label> <input type="text"
						class="form-control" id="price" name="price"
						value="${editproduct.price}"/>
						<p id="isPriceRequired" class = "alert alert-danger">Price cannot be empty</p>
				</div>
				<div class="form-group">
					<label for="category">Category</label> <select id="category"
						name="category" class="form-control">
						<option value="${editproduct.category}">${editproduct.category}</option>
						<c:forEach items="${ categoryList}" var="category">
							<option value="${category}">${category}</option>
						</c:forEach>
					</select>
					<p id="isCategoryRequired" class = "alert alert-danger">Category cannot be empty</p>
				</div>
				<div class="form-group">
					<label for="imageUrl">ImageUrl:</label> <input type="text"
						class="form-control" id="imageUrl" name="imageUrl"
						value="${editproduct.imageUrl}"/>
						<p id="isImageUrlRequired" class = "alert alert-danger">ImageURL cannot be empty</p>
				</div>
				<button type="submit" id="savebtn" class="btn btn-primary">Save</button>
				<!-- <button type="submit" class="btn btn-danger">Delete</button> -->
				<a type="submit" id="deleteButtonId" onclick="deleteProduct(${id})"
					<%-- href="${pageContext.request.contextPath}/deleteProduct/${id}" --%>
					class="btn btn-danger">Delete</a>
			</div>
			<!-- Adding Products Ends -->

			<!-- Previewing Products Starts  -->
			<div class="column">
				<img class="card-img-top" id="cardImage" style="width: 50%"
					src="${editproduct.imageUrl}">
				<p>
					<label class="card-title" id="cardTitle">${editproduct.title}</label>
				</p>
				<p>
					<label class="card-text" id="cardPrice">${editproduct.price}</label>
				</p>
			</div>

		</div>
		<!-- Previewing Products Ends  -->
	</form:form>


</body>
</html>
