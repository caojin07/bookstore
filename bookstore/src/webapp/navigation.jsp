<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="booklist?operation=list">Book Store</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="booklist?operation=list&page=1">Home <span
						class="sr-only">(current)</span></a></li>
			</ul>
			
			<p class="navbar-text navbar-center">Welcome ${me.username} | Share your book,Share your knowledge</p>
			<div class="nav navbar-nav navbar-right">
				<a class="btn nav navbar-btn" href="cart?operation=listcart"> <span
					class="glyphicon glyphicon-shopping-cart"></span> <span
					class="badge" id="cartnumber">${booknumber}</span>
				</a>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Action <span class="caret"></span></a>
						<ul class="dropdown-menu">
						    <li><a href="booklist?operation=list">Home</a></li>
							<li><a href="profile.jsp">Profile</a></li>
							<li><a href="booklist?operation=list&mybook=yes">My book</a></li>
							<li><a href="borrow?op=in">Borrow list</a></li>
							<li><a href="borrow?op=out">Borrow out</a></li>
							<li><a href="upload.jsp">Upload</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="login?action=logout">Logout</a></li>
							<li><a href="register.jsp">Register</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</nav>