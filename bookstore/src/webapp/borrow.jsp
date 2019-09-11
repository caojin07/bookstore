<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="js/borrow.js"></script>

</head>
<body style="background:url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 80px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Borrow list</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-hover">
						<tr>
							<th>Book</th>
							<th>Start date</th>
							<th>End date</th>
							<th>Status</th>
							<th>Comment</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${borrowHistory}" var="item">
							<tr>
								<td>${item.book.name}</td>
								<td><fmt:formatDate value="${item.startdate }"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${item.enddate }"
										pattern="yyyy-MM-dd" /></td>
								<td>${item.status}</td>
								<td><textarea id="${item.id}" readonly rows=3>${item.comment}</textarea></td>
								<td><c:choose>
										<c:when test="${item.status=='finish' }">
											<button class="btn btn-primary btn-sm" data-toggle="modal"
												data-target="#myModal" onclick="setid(${item.id})">Edit</button>
										</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Edit Comment</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="password" class="control-label">Comment:</label>
							<textarea class="form-control" id="idcomment" required="required"></textarea>
							<span id="comment.info" style="color: red"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="closebutton" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="SaveComment()">Save</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>