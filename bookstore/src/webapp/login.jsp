<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>login</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	var remember = '${remember}';
</script>
<script src="js/login.js"></script>

</head>
<body>
	<div class="container">
		<div class="form row">
			<div class="form-horizontal col-md-offset-3" id="login_form">
				<h4 class="form-title">Share your book</h4>
				<h4 class="form-title">Share your knowledge</h4>
				<form action="login?action=login" method="post">
					<div class="col-md-9">
						<div>
							<label>${requestScope.message} </label>
						</div>
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <input
								class="form-control required" type="text" placeholder="I Number"
								id="username" name="username" value="${username}"
								autofocus="autofocus" maxlength="20" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <input
								class="form-control required" type="password"
								placeholder="Password" id="password" name="password"
								value="${password}" maxlength="20" />
						</div>
						<div class="form-group">
							<label class="checkbox"> <input type="checkbox"
								id="remembercheck" name="remember" value="checked" />Remember
								me
							</label>
						</div>
						<div class="form-group col-md-offset-9">
							<a class="btn btn-success" href="register.jsp">Register</a>
							<button type="submit" class="btn btn-success "
								name="submit">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>