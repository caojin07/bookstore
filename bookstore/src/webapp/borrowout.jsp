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
<script src="js/borrowout.js"></script>

</head>
<body style="background: url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 80px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Borrowout list</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-hover">
						<tr>
						<th>Action</th>
							<th>User</th>
							<th>Book</th>
	
							<th>Status</th>
							<th>Comment</th>
							
						</tr>
						<c:forEach items="${borrowoutHistory}" var="item">
							<tr>
							<td>
									<div class="btn-group">
										<c:choose>
											<c:when test="${item.status=='order' }">
												<a class="btn btn-primary btn-xs" href="borrow?op=confirm&id=${item.id }">Confirm</a>
												<a class="btn btn-primary btn-xs" href="borrow?op=reject&id=${item.id }">Reject</a>
											</c:when>
										</c:choose>

										<c:choose>
											<c:when test="${item.status=='confirm' }">
												<a class="btn btn-primary btn-xs" href="borrow?op=finish&id=${item.id }">Finish</a>
											</c:when>
										</c:choose>
									</div>
								</td>
								<td>${item.user.username}</td>
								<td>${item.book.name}</td>
			
								<td>${item.status}</td>
								<td>${item.comment}</td>
								
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>