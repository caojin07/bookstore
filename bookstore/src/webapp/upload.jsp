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
<link href="css/fileinput.min.css" rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/fileinput.min.js"></script>
<script src="js/upload.js"></script>
</head>
<body style="background:url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 60px">
			<h3>Upload Book</h3>
			<form action="booklist?operation=upload&id=${book.id}" class="form-horizontal"
				role="form" method="post" enctype='multipart/form-data' id="form">
				<div class="form-group">
					<label for="category" class="col-sm-2 control-label">Category</label>
					<div class="col-sm-9">
						<select class="form-control" name="category" id="categoryid">
							<c:forEach items="${categorylist}" var="category">
								<c:choose>
									<c:when test="${category.category == book.category }">
										<option value="${category.category }" selected="selected">${category.description }</option>
									</c:when>
									<c:otherwise>
										<option value="${category.category }">${category.description }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> <span id="category.info" style="color: red"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="subcategory" class="col-sm-2 control-label">Sub
						category</label>
					<div class="col-sm-9">
						<select class="form-control" name="subcategory" id="subcategoryid">
							<c:choose>
								<c:when test="${book.subCategory != '' }">
									<option value="${book.subCategory }" selected="selected">${book.subCategory }</option>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</select> <span id="subcategory.info" style="color: red"></span>
					</div>
				</div>

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name </label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="txtName" name="name"
							placeholder="Please specify book name" value="${book.name }" required> <span
							id="name.info" style="color: red"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-9">
						<textarea class="form-control" id="txtDescription" rows="3" 
							name="description" placeholder="Please specify book description"
							required>${book.description }</textarea>
						<span id="description.info" style="color: red"></span>
					</div>
				</div>
				<div class="form-group" id="uploadForm">
					<label for="file" class="col-sm-2 control-label">Image</label>
					<div class="fileinput fileinput-new col-sm-9"
						data-provides="fileinput" id="exampleInputUpload">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: auto; max-height: 150px;">
							<img id='picImg'
								style="width: 100%; height: auto; max-height: 140px;"
								src="booklist?operation=image&id=${book.id}" alt="" />
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="max-width: 200px; max-height: 150px;"></div>
						<div>
							<span class="btn btn-primary btn-file"> <span
								class="fileinput-new">Choose file</span> <span
								class="fileinput-exists">Change</span> <input type="file"
								name="pic1" id="picID" accept="image/gif,image/jpeg,image/x-png" />
							</span> <a href="javascript:;" class="btn btn-warning fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 pull-right">
						<button type="submit" id="uploadSubmit" class="btn btn-info">Submit</button>
					</div>
				</div>
			</form>
		</div>
		<%@ include file="right.jsp"%>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>