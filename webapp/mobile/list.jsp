<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Mobile</title>
</head>
<body>

<%@ include file="../../layout/header2.jsp"%>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-8">
				<h4>Smart Phone's</h4>
				<br><!--  <a href="../books?price=asc">Low to High</a> &nbsp; &nbsp;
				<a href="../books?price=desc">High to Low</a> &nbsp; &nbsp; <a
					href="../books?releaseddate=desc">Recent update</a> -->


				<c:forEach items="${mobiles}" var="mobile">
					<div class="row book-container-bg">
						<div class="col-lg-4 col-md-4 col-xs-12">

							<c:if test="${mobile.id == 6 }">
								<img class="card-img-left" src="../assets/images/6.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${mobile.id == 7 }">
								<img class="card-img-left" src="../assets/images/7.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${mobile.id == 8 }">
								<img class="card-img-left" src="../assets/images/8.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${mobile.id == 9}">
								<img class="card-img-left" src="../assets/images/9.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${mobile.id == 10}">
								<img class="card-img-left"
									src="../assets/images/10.jpg" width="100"
									alt="Card image cap">
							</c:if>

							<%-- <c:if test="${book.id == 6}">
								<img class="card-img-left"
									src="../assets/images/halfgirlfrnd.jpg" width="100"
									alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 7}">
								<img class="card-img-left" src="../assets/images/apj.jpg"
									width="100" alt="Card image cap">
							</c:if> --%>

						</div>

						<div class="col-lg-8 col-md-8 col-xs-12">
							<p class="card-text">
								<b>${mobile.name}<b> <br> -Rs.${mobile.price }
							</p>
							<a href="../mobile/${mobile.id}" class="btn btn-primary">View</a>
						</div>

					</div>

				</c:forEach>
			</div>
		</div>
	</div>


</body>
</html>