<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	src="${pageContext.request.contextPath}/resources/js/home.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css" />
</head>
<body>
	<form:form action="#" id="myForm" method="post">
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
									Orders </a></li>
							<li><a
								href="${pageContext.request.contextPath}/manageProduct">Manage
									Products</a></li>
							<li><a href="${pageContext.request.contextPath}/login">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
		<c:out value="${user}"></c:out>
		<c:out value="${role }"></c:out>
		<!-- Side navigation and displaying images starts -->

		<div class="container">
			<div class="row">

				<!-- Category Frames -->
				<div id="myBtnContainer">
					<div class="col-md-3 text-center">
						<br />
						<div class="sticky-top">
							<div class="list-group" align="left">
								<a class="btn list-group-item list-group-item-action"
									id="activeCategory" href="${pageContext.request.contextPath}/">All
									Product</a>
								<c:forEach items="${categoryList }" var="category">
									<a class="btn list-group-item list-group-item-action"
										id="activeCategory"
										href="${pageContext.request.contextPath}/getProductsByCategory/${category}">${category }</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>

				<!-- Category Frames Ends-->

				<!-- Images Frames -->

				<div class="col-md-9 text-center">
					<div class="row" align="center">
						<c:forEach items="${productList}" var="product">
							<div class="col-md-4">
								<div class="panel panel-default" style="width: 20rem;"
									align="center">
									<img src="${product.imageUrl}" class="card-img-top"
										alt="Card image cap" style="width: 100%">
									<!-- Panel body -->
									<div class="panel-body">
										<h4 class="card-title">${product.title}</h4>
										<p class="card-text">${product.price}</p>
										<!-- Panel footer -->
										<div class="panel-footer" align="left">
											<a class="btn btn-primary btn-block" id="addToCartId"
												href="#" onclick="addToCart(${product.id})">Add to Cart
											</a>
										</div>
									</div>
								</div>
							</div>
							<div class="modal fade" id="myModal" role="dialog">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Modal Header</h4>
										</div>
										<div class="modal-body">
											<p>Your Item has been successfully added to cart.</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>

								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- Images Frames Ends-->
			</div>
		</div>
	</form:form>
</body>
</html>
