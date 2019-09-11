<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="css/bootstrap-select.min.css">

<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/register.css" rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>

<script src="js/bootstrap-select.js"></script>
<script src="js/register.js"></script>
</head>
<body style="background:url(img/1.jpg);background-repeat:no-repeat; background-size:100%;">
	<div class="container">
		<div class="form row">
			<div class="form-horizontal col-md-offset-3" id="register_form">
				<h3 class="form-title">Register</h3>
				<form action="register" class="form-horizontal" role="form"
					method="post" id="form">
					<div class="form-group">
						<label for="inumber" class="col-sm-2 control-label">I
							number</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="txtInumber"
								name="inumber" placeholder="Please specify your I number"
								required> <span id="inumber.info" style="color: red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">User
							name</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="txtUserName"
								name="username" placeholder="Please specify your name" required="required">
							<span id="username.info" style="color: red"></span>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" name="password"
								id="txtPassword" placeholder="Please specify password" required="required">
							<span id="password.info" style="color: red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="repeatPass" class="col-sm-2 control-label">Repeat
							password</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" name="repeatPass"
								id="txtRepeatPass" placeholder="Please repeat password" required="required">
							<span id="repeatPass.info" style="color: red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="location" class="col-sm-2 control-label">Location</label>
						<div class="col-sm-6">
							<select class="form-control" name="location" id="txtlocation">
								<c:forEach items="${locationlist}" var="location">
									<option value="${location.location }">${location.description }</option>
								</c:forEach>
							</select> <span id="location.info" style="color: red"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="gender" class="col-sm-2 control-label">Gender</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								value="male" name="gender" checked>Male
							</label> <label class="radio-inline"> <input type="radio"
								value="female" name="gender">Female
							</label>
						</div>
					</div>

					<div class="form-group">
						<label for="smallgroup" class="col-sm-2 control-label">Group</label>
						<div class="col-sm-6">
							<select class="form-control" name="smallgroup" id="txtsmallgroup">
								<c:forEach items="${grouplist}" var="groupline">
									<option value="${groupline.smallgroup }">${groupline.description }</option>
								</c:forEach>
							</select> <span id="smallgroup.info" style="color: red"></span>
						</div>
					</div>
					<!-- <div class="form-group">
						<label for="birthday" class="col-sm-2 control-label">Birthday</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="birthday"
								id="txtBirthday" data-date="1990-01-01"
								data-date-format="yyyy-mm-dd" placeholder="Date" required="required">
							<span id="birthday.info" style="color: red"></span>
						</div>
					</div> -->

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Register</button>
							<a class="btn btn-primary" href="login">Login</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>