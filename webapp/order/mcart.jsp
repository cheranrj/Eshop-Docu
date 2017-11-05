<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Cart</title>
</head>
<body>

<%@ include file="../../layout/header2.jsp"%>
	<div class="content">
		<div class="container-fluid">

			<div class="row">

				<div class="col-md-8">
					<h5>My Cart</h5>
					<%-- <c:if
						test="${empty MY_CART_ITEMS || MY_CART_ITEMS.orderItems.isEmpty()}">
						<img src="../assets/images/empty-cart.png" width="300" />
						<h5>Your Shopping Cart is empty</h5>
						<a href="../mobile" class="btn btn-info">Continue Shopping</a>
					</c:if> --%>
					<c:if
						test="${!empty MY_CART_ITEMS && !MY_CART_ITEMS.orderItems.isEmpty()}">
						<table border="1" class="table table-bordered">
							<thead>
								<tr>
									<th width="10%">#</th>
									<th>Item Name</th>
									<th>Quantity</th>
									<th>Total Cost</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${MY_CART_ITEMS.orderItems}" var="item"
									varStatus="loop">
									<tr>
										<td>${loop.index+1}</td>
										<td>${item.mobile.name}</td>
										<td>${item.quantity}</td>
										<td>Rs.${item.mobile.price*item.quantity }</td>
										<td><a href="../morderItems/mremove?id=${loop.index}"
											class="btn btn-danger">Remove</a>
									</tr>
								</c:forEach>
							</tbody>
						</table>


						<br />
						<a href="../mobile" class="btn btn-info">Continue Shopping</a>


					</c:if>
				</div>

				<c:if
					test="${ MY_CART_ITEMS != null && MY_CART_ITEMS.orderItems.size()>0}">
					<div class="col-md-4">
						<b>Price Details</b>

						<c:set var="no_of_items"
							value="${MY_CART_ITEMS.orderItems.size()}" />
						<c:set var="total_amount" value="0" />
						<c:forEach items="${MY_CART_ITEMS.orderItems}" var="item">
							<c:set var="total_amount"
								value="${total_amount + item.mobile.price*item.quantity}" />
						</c:forEach>

						<form name="orderForm" action="../morders/msave" method="post">
							<input type="hidden" name="total_amount" value="${total_amount}" />
							<table border="1" class="table table-bordered">

								<tbody>
									<tr>
										<td>Price ( ${no_of_items != null ?no_of_items:0} items )</td>
										<td>Rs. ${total_amount}</td>
									</tr>
									<tr>
										<td>Payment Mode</td>
										<td><select name="paymentmode">

												<option value="card">card</option>
												<option value="cahs">cash</option>
										</select></td>
									</tr>
									<tr>
										<td>Delivery Charges</td>
										<td>FREE</td>
									</tr>
									<tr>
										<th><b>Amount Payable </b></th>
										<th><b>Rs. ${total_amount}</b></th>
									</tr>
									<tr>
										<td colspan="2" align="center">

											<button type="submit" class="btn btn-success btn-block">Place
												an Order</button>
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>