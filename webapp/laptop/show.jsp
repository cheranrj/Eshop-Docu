<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div><%@ include file="../../layout/header3.jsp"%></div>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12">

				<b>Item Details</b>
				<c:if test="${empty LOGGED_IN_USER}">
					<div class="alert alert-danger" role="alert">
						Please <strong>Login</strong> to add items to cart.
					</div>
				</c:if>

				<form action="../lorderItems/laddToCart" method="post">
					<input type="hidden" name="laptop_id" value="${SELECTED_Laptop.id}" />
					<table class="table table-bordered" border="1">
						<tr>
							<th>Mobile Name</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
						<tr>

							<td>${SELECTED_Laptop.name}</td>

							<td>Rs. ${SELECTED_Laptop.price}</td>
							<td><input type="number" name="mqty" min="1" max="5"
								value="1" required /></td>

							<c:if test="${!empty LOGGED_IN_USER}">
								<td><button type="submit" class="btn btn-primary">Add
										To Cart</button></td>
							</c:if>
							<c:if test="${empty LOGGED_IN_USER}">
								<td><button type="submit" class="btn btn-primary">Add
										To Cart</button></td>
							</c:if>

						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>