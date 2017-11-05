<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Books</title>


</head>
<body>

	<%@ include file="../../layout/header.jsp"%>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-8">
				<h4>Smart TV's</h4>
				<br><!--  <a href="../books?price=asc">Low to High</a> &nbsp; &nbsp;
				<a href="../books?price=desc">High to Low</a> &nbsp; &nbsp; <a
					href="../books?releaseddate=desc">Recent update</a> -->


				<c:forEach items="${books}" var="book">
					<div class="row book-container-bg">
						<div class="col-lg-4 col-md-4 col-xs-12">

							<c:if test="${book.id == 1 }">
								<img class="card-img-left" src="../assets/images/1.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 2 }">
								<img class="card-img-left" src="../assets/images/2.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 3 }">
								<img class="card-img-left" src="../assets/images/3.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 4}">
								<img class="card-img-left" src="../assets/images/4.jpg"
									width="100" alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 5}">
								<img class="card-img-left"
									src="../assets/images/5.jpg" width="100"
									alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 6}">
								<img class="card-img-left"
									src="../assets/images/halfgirlfrnd.jpg" width="100"
									alt="Card image cap">
							</c:if>

							<c:if test="${book.id == 7}">
								<img class="card-img-left" src="../assets/images/apj.jpg"
									width="100" alt="Card image cap">
							</c:if>

						</div>

						<div class="col-lg-8 col-md-8 col-xs-12">
							<p class="card-text">
								<b>${book.name}<b> <br> -Rs.${book.price }
							</p>
							<a href="../tv/${book.id}" class="btn btn-primary">View</a>
						</div>

					</div>

				</c:forEach>
			</div>
		</div>
	</div>


</body>
</html>