<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../../layout/header3.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong><i class="fa fa-list"></i> All Orders</strong>
					</div>
					<div class="panel-body">
						<table id="ordersTbl" border="1"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="10%">Order Id</th>
									<th>Customer Name</th>
									<th>Items</th>
									<th>Order Amount</th>
									<th>Status</th>
									<th>Ordered Date</th>
								</tr>
							</thead>
							<tbody>
							
														
								<c:forEach items="${ORDERS_LIST}" var="order">
									<tr>
										<td>${order.id}</td>
										<td>${order.user.name}</td>
										<td>
											<ul>
												<c:forEach items="${order.orderItems}" var="item">
													<li>${item.laptop.name}(Quantity-${item.quantity})</li>
												</c:forEach>
											</ul>
										</td>
										<td>Rs. ${order.totalPrice}</td>
										<td>${order.status}</td>
										<td>${order.orderedDate}</td>
										<c:if test="${order.status == 'ORDERED'}">
											<td><a
												href="../lorders/lupdateStatus?id=${order.id}&status=CANCELLED"
												class="btn btn-danger">Cancel Order </a></td>
										</c:if>
										<c:if test="${order.status == 'ORDERED'}">
											<c:if test="${LOGGED_IN_USER.role.id==1}">
												<td><a
													href="../lorders/lupdateStatus?id=${order.id}&status=DELIVERED"
													class="btn btn-success">Delivered Order </a></td>
											</c:if>
										</c:if>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>