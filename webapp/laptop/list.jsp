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
			<div class="col-md-8">
				<h4>Smart Phone's</h4>
				<br><!--  <a href="../books?price=asc">Low to High</a> &nbsp; &nbsp;
				<a href="../books?price=desc">High to Low</a> &nbsp; &nbsp; <a
					href="../books?releaseddate=desc">Recent update</a> -->


				<c:forEach items="${laptop}" var="laptop">
					<div class="row book-container-bg">
						<div class="col-lg-4 col-md-4 col-xs-12">

							<c:if test="${laptop.id == 11 }">
								<img class="card-img-left" src="../assets/images/11.jpg" width="250" height="150"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${laptop.id == 12 }">
								<img class="card-img-left" src="../assets/images/12.jpg" width="250" height="150"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${laptop.id == 13 }">
								<img class="card-img-left" src="../assets/images/13.jpg" width="250" height="150"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${laptop.id == 14}">
								<img class="card-img-left" src="../assets/images/14.jpg" width="250" height="150"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${laptop.id == 15}">
								<img class="card-img-left"
									src="../assets/images/15.jpg" width="250" height="150"
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
								<b>${laptop.name}<b> <br> -Rs.${laptop.price }
							</p>
							<a href="../laptop/${laptop.id}" class="btn btn-primary">View</a>
						</div>

					</div>

				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>