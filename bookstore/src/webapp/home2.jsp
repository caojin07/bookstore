<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

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
<link
	href="https://cdn.bootcss.com/jquery-confirm/3.3.2/jquery-confirm.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<script src="js/home.js"></script>

</head>
<body
	style="background: url(img/bg2.jpg); background-repeat: no-repeat; background-size: 100%;">
	<%@ include file="navigation.jsp"%>
	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 60px">
			<!-- 开加一个container的目的是为了让整体布局居中 -->
			<!-- 开始 -->
			<div class="row fluid">
				<div class="page-header">
					<div>
						<c:choose>
							<c:when test="${mybook=='yes'}">
								<h4>My Book List</h4>
							</c:when>
							<c:otherwise>
								<h4>Book List</h4>
							</c:otherwise>
						</c:choose>
					</div>
					<div>
						<form action="booklist?operation=list&mybook=${mybook }"
							class="form-horizontal" role="form" method="post" id="form">
							<div class="form-group">
								<div class="col-sm-3">
									<select class="form-control" name="category" id="category">
										<option value="all" selected="selected">All category</option>
										<c:forEach items="${categorylist}" var="category">
											<c:choose>
												<c:when test="${category.category == filtercategory }">
													<option value="${category.category }" selected="selected">${category.description }</option>
												</c:when>
												<c:otherwise>
													<option value="${category.category }">${category.description }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<c:choose>
									<c:when test="${mybook=='yes'}">
									</c:when>
									<c:otherwise>
										<div class="col-sm-3">
											<select class="form-control" name="user" id="user">
												<option value="0" selected="selected">All Owner</option>
												<c:forEach items="${userlist}" var="user">
													<c:choose>
														<c:when test="${user.id == filteruser}">
															<option value="${user.id }" selected="selected">${user.username }</option>
														</c:when>
														<c:otherwise>
															<option value="${user.id }">${user.username }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</c:otherwise>
								</c:choose>
								<div class="col-sm-3">
									<select class="form-control" name="status" id="status">
										<option value="all" selected="selected">All Status</option>
										<c:choose>
											<c:when test="${filterstatus == 'In store' }">
												<option value="In store" selected="selected">In store</option>
											</c:when>
											<c:otherwise>
												<option value="In store">In store</option>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${filterstatus == 'order' }">
												<option value="order" selected="selected">order</option>
											</c:when>
											<c:otherwise>
												<option value="order">order</option>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${filterstatus == 'Borrow out' }">
												<option value="Borrow out" selected="selected">Borrow out</option>
											</c:when>
											<c:otherwise>
												<option value="Borrow out">Borrow out</option>
											</c:otherwise>
										</c:choose>

									</select>
								</div>
								<div class="col-sm-3">
									<button type="submit" class="btn btn-success " name="submit">Search</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div>
					<c:forEach items="${bookList}" var="book">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
							<!-- 大屏幕放3张略缩图，pc端放4张，平板和手机放2张-->
							<div class="thumbnail">
								<a href="booklist?operation=detail&id=${book.id }"> <img
									style="height: 210px; display: block;"
									src="booklist?operation=image&id=${book.id}" alt="..."
									class="img-responsive">
								</a>
								<div class="caption">
									<div style="height: 100px; font-size: 0px">
										<h6>${book.name }</h6>
										<h6>Category:${book.category }</h6>
										<h6>
											<small>${book.description }</small>
										</h6>
									</div>
								</div>
								<div class="text-right">
									<span class="text-primary"> ${book.status }&nbsp;&nbsp;&nbsp;
										<c:choose>
											<c:when test="${me.id == book.userid }">
												<a class="btn btn-danger btn-xs"
													href="booklist?operation=detail&id=${book.id }">Detail</a>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${book.status == 'In store' }">
														<a class="btn btn-primary btn-xs"
															onClick="add_book(this,${book.id})" href="#">Add</a>
													</c:when>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</span>
								</div>
							</div>
						</div>
						<!-- 第一张略缩图结束 -->
					</c:forEach>
				</div>
			</div>
			<div class="text-center">
				<ul class="pagination">
					<li><a
						href="booklist?operation=list&mybook=${mybook }&page=1&category=${filtercategory }&status=${filterstatus }&user=${filteruser }">First</a></li>
					<c:forEach begin="1" end="${totalpages }" var="cur" step="1">
						<c:choose>
							<c:when test="${currentpage == cur }">
								<li class="active"><a
									href="booklist?operation=list&mybook=${mybook }&page=${cur}&category=${filtercategory }&status=${filterstatus }&user=${filteruser }">${cur}</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="booklist?operation=list&mybook=${mybook }&page=${cur}&category=${filtercategory }&status=${filterstatus }&user=${filteruser }">${cur}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<li><a
						href="booklist?operation=list&mybook=${mybook }&page=${totalpages }&category=${filtercategory }&status=${filterstatus }&user=${filteruser }">Last</a></li>
				</ul>
			</div>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>