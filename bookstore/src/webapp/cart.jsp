<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script src="js/cart.js"></script>

</head>
<body style="background:url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 80px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Cart list</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-hover">
						<tr>
							<th>Owner</th>
							<th>Book Name</th>
							<th>Category</th>
							<th>Sub Category</th>
							<th>Status</th>
							<th>Remove</th>
						</tr>
						<c:forEach items="${cartMap}" var="item">
							<tr>
								<td>${item.value.user.username}</td>
								<td>${item.value.name}</td>
								<td>${item.value.category}</td>
								<td>${item.value.subCategory}</td>
								<td>${item.value.status}</td>
								<td><a class="btn btn-danger"
									onClick="remove_book(this,${item.value.id})" href="#">Remove</a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="btn-group pull-right" role="group" aria-label="...">
						<c:choose>
							<c:when test="${fn:length(cartMap)==0}">
								<a class="btn btn-primary" href="#" disabled="disabled">Order</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="cart?operation=order">Order</a>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>