<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="css/bootstrap-select.min.css">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>

<script src="js/bootstrap-select.js"></script>
<script src="js/profile.js"></script>
<script type="text/javascript">
	var message = '${message}';
</script>
</head>
<body style="background:url(img/bg2.jpg);background-repeat:no-repeat; background-size:100%;">
	<%@ include file="navigation.jsp"%>

	<div class="container-fluid">
		<div class="bg container col-md-9" style="margin-top: 80px">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Person information</h3>
				</div>

				<div class="panel-body">
					<div>
						<button class="btn btn-danger pull-right" data-toggle="modal"
							data-target="#myModal">Change Password</button>
					</div>
					<form action="register?op=edit" class="form-horizontal" role="form"
						method="post" id="form">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">User
								name</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="txtUserName"
									name="username" placeholder="Please specify your name"
									value="${me.username }" disabled="disabled" required="required">
								<span id="username.info" style="color: red"></span>
							</div>
						</div>

						<div class="form-group">
							<label for="location" class="col-sm-2 control-label">Location</label>
							<div class="col-sm-6">
								<select class="form-control" name="location" id="txtlocation"
									disabled="disabled">
									<c:forEach items="${locationlist}" var="location">
										<c:choose>
											<c:when test="${location.location==me.location }">
												<option value="${location.location }" selected="selected">${location.description }</option>
											</c:when>
											<c:otherwise>
												<option value="${location.location }">${location.description }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select> <span id="location.info" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-6">
								<c:choose>
									<c:when test="${me.gender=='male'}">
										<label class="radio-inline"> <input type="radio"
											value="male" name="gender" id="idgenderm" checked
											disabled="disabled">Male
										</label>
										<label class="radio-inline"> <input type="radio"
											value="female" name="gender" id="idgenderfm"
											disabled="disabled">Female
										</label>
									</c:when>
									<c:otherwise>
										<label class="radio-inline"> <input type="radio"
											value="male" name="gender" id="idgenderm" disabled="disabled">Male
										</label>
										<label class="radio-inline"> <input type="radio"
											value="female" name="gender" id="idgenderfm" checked
											disabled="disabled">Female
										</label>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<div class="form-group">
							<label for="smallgroup" class="col-sm-2 control-label">Group</label>
							<div class="col-sm-6">
								<select class="form-control" name="smallgroup"
									id="txtsmallgroup" disabled="disabled">
									<c:forEach items="${grouplist}" var="groupline">
										<c:choose>
											<c:when test="${me.smallgroup==groupline.smallgroup}">
												<option value="${groupline.smallgroup }" selected="selected">${groupline.description }</option>
											</c:when>
											<c:otherwise>
												<option value="${groupline.smallgroup }">${groupline.description }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select> <span id="smallgroup.info" style="color: red"></span>
							</div>
						</div>
						<%-- <div class="form-group">
							<label for="birthday" class="col-sm-2 control-label">Birthday</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" disabled="disabled"
									name="birthday" id="txtBirthday" data-date="1990-01-01"
									data-date-format="yyyy-mm-dd" placeholder="Date"
									value="<fmt:formatDate value="${me.birthday }" pattern="yyyy-MM-dd"/>" required="required"></input> <span
									id="birthday.info" style="color: red"></span>
							</div>
						</div> --%>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a class="btn btn-primary" href="#" onclick="Swithmode()">Edit</a>
								<button id="idsubmit" type="submit" class="btn btn-primary"
									disabled="disabled">Submit</button>
							</div>
						</div>
					</form>
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
					<h4 class="modal-title" id="myModalLabel">Change Password</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="password" class="control-label">Password:</label> <input
								type="password" class="form-control" id="idpassword"
								required="required"></input> <span id="password.info"
								style="color: red"></span>
						</div>
						<div class="form-group">
							<label for="idnewpassword" class="control-label">New
								Password:</label> <input type="password" class="form-control"
								id="idnewpassword" required="required"></input><span
								id="newpassword.info" style="color: red"></span>
						</div>
						<div class="form-group">
							<label for="idrepeatpassword" class="control-label">Repeat
								Password:</label> <input type="password" class="form-control"
								id="idrepeatpassword" required="required"></input><span
								id="repeatpassword.info" style="color: red"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="closebutton" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="ChangePassword()">Change</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>