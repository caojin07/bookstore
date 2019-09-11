<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Share your books</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/book.js"></script>

</head>
<body style="background: url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 80px">
			<div class="col-lg-3 col-md-3 col-sm-6 ">
				<!-- 大屏幕放3张略缩图，pc端放4张，平板和手机放2张img/bimg/template.jpg-->
				<div class="thumbnail">
					<a href="#"> <img src="booklist?operation=image&id=${book.id}"
						alt="..." class="img-responsive">
					</a>
				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Book information</h3>
					</div>

					<div class="panel-body">
						<h5>${book.name}</h5>
						<h5>Category:${book.category}</h5>
						<h5>Sub Category:${book.subCategory}</h5>
						<h5>Owner:${book.user.username}</h5>
						<h5>Upload date:${book.date}</h5>
						<h5>Status：${book.status}</h5>
						<h5>Description:${book.description }</h5>
						
						<div class="btn-group pull-right" role="group" aria-label="...">
							<c:choose>
								<c:when test="${me.id==book.userid}">
									<a class="btn btn-primary"
										href="booklist?operation=edit&id=${book.id }">Edit</a>
									<a class="btn btn-danger"
										href="booklist?operation=delete&id=${book.id}">Delete</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${book.status=='In store'}">
											<button type="button" class="btn btn-primary" id="addtocart">Add
												to Cart</button>
											<a class="btn btn-primary" href="cart?operation=borrow">Borrow</a>
										</c:when>
									</c:choose>
									<a class="btn btn-primary" href="cart?operation=listcart">Cart</a>
								</c:otherwise>
							</c:choose>

						</div>
					</div>

				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Borrow history</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-hover">
							<tr>
								<th>User</th>
								<th>Start date</th>
								<th>End date</th>
								<th>Status</th>
								<th>Comment</th>
							</tr>
							<c:forEach items="${borrowHistory}" var="item">
								<tr>
									<td>${item.user.username}</td>
									<td>${item.startdate}</td>
									<td>${item.enddate}</td>
									<td>${item.status}</td>
									<td>${item.comment}</td>
								</tr>
							</c:forEach>
						</table>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>